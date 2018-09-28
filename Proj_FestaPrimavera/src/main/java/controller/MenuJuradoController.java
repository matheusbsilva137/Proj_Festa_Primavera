package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Avaliacao;
import view.App;

public class MenuJuradoController extends Application implements Initializable{
	@FXML
    private AnchorPane raiz;
    
	@FXML
    private TableView<tvAvaliacaoController> tvAvaliacao;

    @FXML
    private TableColumn<tvAvaliacaoController, Integer> tcRM_Avl;

    @FXML
    private TableColumn<tvAvaliacaoController, Integer> tcID_Avaliacao_Avl;

    @FXML
    private TableColumn<tvAvaliacaoController, Integer> tcIdade_Avl;

    @FXML
    private TableColumn<tvAvaliacaoController, Integer> tcID_Jurado_Avl;

    @FXML
    private TableColumn<tvAvaliacaoController, Double> tcNota_Avl;

    @FXML
    private JFXTextField txbNota_Avl;
    @FXML
    private JFXTextField txbNotas;

    @FXML
    public JFXComboBox<String> cmbCriterio_Avl;
    
    @FXML
    public JFXComboBox<String> cmbEdicoes;
    
    @FXML
    public JFXComboBox<String> cmbAlunos;
    
    @FXML
    public JFXTextField txbLogin;
    
    @FXML
    private JFXButton btnRmv_Avl;
    
    @FXML
    private JFXButton btnSelCriterios;
    
    @FXML
    private JFXButton btnSelEd;
    
    @FXML
    private JFXButton btnSelAlunos;
    
    @FXML
    private JFXButton btnAval;

    @FXML
    private Label lblAvl;
    
    @FXML
    private Label lblPontuacao;
    
    public String login;
    double pontuacao = 0;
    
    AvaliacaoJpaDAO avlDAO  = new AvaliacaoJpaDAO();
	List<Avaliacao> avlList;
	ObservableList<tvAvaliacaoController> listAvaliacaoTabela = FXCollections.observableArrayList();
	
	@Override
	public void start(Stage menu) throws Exception {
		this.raiz = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/Jurado_Menu.fxml"));
		menu.initStyle(StageStyle.DECORATED);
		
		menu.setMaximized(false);
		menu.setFullScreen(false);
		menu.setResizable(false);
		menu.setTitle("Festa da Primavera - Jurado");
		
        menu.getIcons().add(new Image(App.class.getResourceAsStream("iconLogin.png")));

		Scene scene = new Scene(raiz);
		menu.setScene(scene);
		menu.show();
	}
	
	public void setLoginAtual(String login) {
		this.login = login;
	}
	
	public String getLoginAtual() {
		return this.login;
	}
	
	@FXML
	public void carregarEdicoes() {
		cmbEdicoes.setDisable(false);
		btnSelAlunos.setDisable(false);
		this.setLoginAtual(txbLogin.getText());
		cmbEdicoes.getItems().clear();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String sql = String.format("SELECT ano FROM convite WHERE login = '%s'",this.getLoginAtual());
		List result = session.createSQLQuery(sql).list();
		for(int i=0; i<result.size(); i++){
			cmbEdicoes.getItems().add(result.get(i).toString());
		}
		session.getTransaction().commit();
		session.close();
	}
	
	@FXML
	private void carregarAlunos() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT p.rm, c.nome FROM Participacao p INNER JOIN Competidor c ON p.rm = c.rm WHERE p.edicao = "+cmbEdicoes.getValue()+" ORDER BY c.nome ASC");
		List<Object[]> alunosCompet = (List<Object[]>)q.list();
	    for(Object[] aluno: alunosCompet){
	    	cmbAlunos.getItems().add(aluno[0].toString()+" - "+aluno[1].toString());
	    }
	    cmbAlunos.setDisable(false);
	    btnSelCriterios.setDisable(false);
		session.getTransaction().commit();
		session.close();
	}
	
	
	@FXML
	private void carregarCriterios() {
		cmbCriterio_Avl.getItems().clear();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String sql = String.format("SELECT criterios FROM competicao WHERE edicao = %s;",cmbEdicoes.getValue());
		SQLQuery query = session.createSQLQuery(sql).addScalar("criterios");
		List result = query.list();
		session.getTransaction().commit();
		session.close();
		
		String[] stringCriterios = result.get(0).toString().split(",");
		for(int i = 0; i<stringCriterios.length; i++) {
			cmbCriterio_Avl.getItems().add(stringCriterios[i].toString());
		}
		cmbCriterio_Avl.setDisable(false);
		txbNota_Avl.setDisable(false);
		txbNotas.setText("0");
		for(int i=1; i<cmbCriterio_Avl.getItems().size(); i++) {
			txbNotas.setText(txbNotas.getText()+"+0");
		}
		btnAval.setDisable(false);
	}
	
	@FXML
	public void cadAval(){
			Avaliacao aval = new Avaliacao();
		    aval.setLogin(this.login);
		    aval.setNotas(txbNotas.getText().toString());
		    aval.setPontuacao(Double.parseDouble(lblPontuacao.getText()));
		    String[] rmAluno = cmbAlunos.getValue().split(" ");
		    aval.setRm(Integer.parseInt(rmAluno[0]));
		    cmbAlunos.getItems().remove(cmbAlunos.getSelectionModel().getSelectedIndex());
		    
		    txbNota_Avl.setText("");
		    txbNota_Avl.setText("");
		    lblPontuacao.setText("0.00");
		    txbNotas.setText("");
		    
		    AvaliacaoJpaDAO avalDAO = new AvaliacaoJpaDAO();
		    avalDAO.addAvaliacao(aval);
		}
	
	@FXML
	public void limparNota(){
		int index = cmbCriterio_Avl.getSelectionModel().getSelectedIndex();
		String[] stringNotas = txbNotas.getText().split("[+]");
		txbNota_Avl.setText(stringNotas[index]);
	}
	
	@FXML
	private void atualizarNotas() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Cadastro de Avaliação");
		alert.setHeaderText("Inserção de Nota");
		alert.initOwner((Stage)btnSelCriterios.getScene().getWindow());
		
		if(txbNota_Avl.getText().contains(",")) {
			txbNota_Avl.clear();
			alert.setContentText("A nota digitada é inválida (utilize pontos em vez de vírgulas)");
			alert.show();
			txbNota_Avl.requestFocus();
		}else if(!txbNota_Avl.getText().equals("")){
			if(Double.parseDouble(txbNota_Avl.getText()) > 10) {
				txbNota_Avl.clear();
				alert.setContentText("A nota digitada é inválida (digite um valor menor ou igual a 10)");
				alert.show();
				txbNota_Avl.requestFocus();
			}else {
				int pos = cmbCriterio_Avl.getSelectionModel().getSelectedIndex();
				
				String[] stringNotas = txbNotas.getText().split("[+]");
				stringNotas[pos] = txbNota_Avl.getText();
				
				txbNotas.clear();
				
				txbNotas.setText(stringNotas[0]);
				pontuacao = Double.parseDouble(stringNotas[0]);
				for(int i = 1; i<cmbCriterio_Avl.getItems().size(); i++) {
					txbNotas.setText(txbNotas.getText()+"+"+stringNotas[i]);
					pontuacao += Double.parseDouble(stringNotas[i]);
				}
				lblPontuacao.setText(pontuacao/cmbCriterio_Avl.getItems().size()+"");
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txbLogin.setText(this.getLoginAtual());
	}
}
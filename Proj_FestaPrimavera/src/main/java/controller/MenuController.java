package controller;

import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.hibernate.Query;
import org.hibernate.Session;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Avaliacao;
import model.Competicao;
import model.Competidor;
import model.Convite;
import model.Instituicao;
import model.Jurado;
import model.Participacao;
import view.App;

public class MenuController  extends Application implements Initializable{
	 @FXML
	 private JFXTextField txbRMCptd;
	 @FXML
	 private JFXTextField txbNomeCptd;
	 @FXML
	 AnchorPane raiz;
	 @FXML
	 TableView<tvCompetidorController> tvCompetidor;
		@FXML
		TableColumn<tvCompetidorController, Integer> tcRMCptd;
		@FXML
		TableColumn<tvCompetidorController, String> tcNomeCptd;
		@FXML
		TableColumn<tvCompetidorController, Integer> tcIdadeCptd;
		@FXML
		TableColumn<tvCompetidorController, String> tcSexoCptd;
		@FXML
		TableColumn<tvCompetidorController, String> tcInstituicaoCptd;
		@FXML
		TableColumn<tvCompetidorController, String> tcTurmaCptd;
		 @FXML
		    private JFXButton btnRegCptd;
		 @FXML
		    private JFXButton btnLimpCptd;
	    @FXML
	    private JFXTextField txbTurmaCptd;

	    @FXML
	    private JFXTextField txbIdadeCptd;

	    @FXML
	    private JFXComboBox<String> cmbInstituicaoCptd;
	    @FXML
	    private JFXComboBox<String> cmbPartCptd;
	    @FXML
	    private JFXComboBox<String> cmbCvtJrd;

	    @FXML
	    private JFXRadioButton rbMascCptd;

	    @FXML
	    private ToggleGroup grupoSexo;

	    @FXML
	    private JFXRadioButton rbFemCptd;

	    @FXML
	    private JFXButton btnNovoCptd;

	    @FXML
	    private JFXButton btnRmvCptd;

	    @FXML
	    private Label lblCptd;
	    
	    @FXML
	    private TableView<tvJuradoController> tvJurado;

	    @FXML
	    private TableColumn<tvJuradoController, String> tcNomeJurado;

	    @FXML
	    private TableColumn<tvJuradoController, String> tcOcupacaoJurado;

	    @FXML
	    private TableColumn<tvJuradoController, String> tcLoginJurado;

	    @FXML
	    private JFXTextField txbNomeJurado;

	    @FXML
	    private JFXTextField txbOcupacaoJurado;

	    @FXML
	    private JFXButton btnRegJurado;

	    @FXML
	    private JFXButton btnNovoJurado;

	    @FXML
	    private JFXButton btnRmvJurado;
	    @FXML
	    private JFXButton btnCadPart;
	    @FXML
	    private JFXButton btnNovaInst;

	    @FXML
	    private Label lblJurado;

	    @FXML
	    private JFXButton btnLimpJurado;

	    @FXML
	    private JFXTextField txbLoginJurado;

	    @FXML
	    private JFXPasswordField txbRepeteSenhaJurado;

	    @FXML
	    private JFXPasswordField txbSenhaJurado;
	    @FXML
	    private TableView<tvCompeticaoController> tvCompeticao;

	    @FXML
	    private TableColumn<tvCompeticaoController, Integer> tcEdicaoCptc;

	    @FXML
	    private TableColumn<tvCompeticaoController, String> tcDataCptc;

	    @FXML
	    private TableColumn<tvCompeticaoController, String> tcCriteriosCptc;

	    @FXML
	    private TableColumn<tvCompeticaoController, Integer> tcRmMisterCptc;

	    @FXML
	    private TableColumn<tvCompeticaoController, Integer> tcRmMissCptc;

	    @FXML
	    private JFXTextField txbEdicaoCptc;

	    @FXML
	    private JFXTextField txbMrVCptc;

	    @FXML
	    private JFXButton btnRegCptc;

	    @FXML
	    private JFXButton btnNovoCptc;

	    @FXML
	    private JFXButton btnRmvCptc;

	    @FXML
	    private Label lblCompeticao;

	    @FXML
	    private JFXButton btnRankingCptc;

	    @FXML
	    private JFXTextField txbMsVCptc;

	    @FXML
	    private JFXDatePicker dtpDataCptc;

	    @FXML
	    private TableView<tvRankingMascController> tvRankingMasc;

	    @FXML
	    private TableColumn<tvRankingMascController, Integer> tcPosMascCptc;

	    @FXML
	    private TableColumn<tvRankingMascController, Integer> tcRmMascCptc;

	    @FXML
	    private TableColumn<tvRankingMascController, String> tcNomeMascCptc;

	    @FXML
	    private TableColumn<tvRankingMascController, Double> tcPontuacaoMascCptc;

	    @FXML
	    private TableView<tvRankingFemController> tvRankingFem;

	    @FXML
	    private TableColumn<tvRankingFemController, Integer> tcPosFemCptc;

	    @FXML
	    private TableColumn<tvRankingFemController, Integer> tcRmFemCptc;

	    @FXML
	    private TableColumn<tvRankingFemController, String> tcNomeFemCptc;

	    @FXML
	    private TableColumn<tvRankingFemController, Double> tcPontuacaoFemCptc;

	    @FXML
	    private JFXTextField txbCriteriosCptc;
	    
	    @FXML
	    private TableView<tvAvaliacaoController> tvAvaliacao;

	    @FXML
	    private TableColumn<tvAvaliacaoController, Integer> tcID_Avaliacao_Avl;

	    @FXML
	    private TableColumn<tvAvaliacaoController, Integer> tcRM_Avl;

	    @FXML
	    private TableColumn<tvAvaliacaoController, String> tcID_Jurado_Avl;

	    @FXML
	    private TableColumn<tvAvaliacaoController, Double> tc_Pontuacao_Avl;
	    
	    @FXML
	    private JFXComboBox<String> cmbJuradoAvl;
	    
	    @FXML
	    private JFXComboBox<String> cmbAlunoAvl;

	    @FXML
	    private JFXButton btnRmv_Avl;

	    @FXML
	    private Label lblAvl;

	    
	    CompetidorJpaDAO cptdDAO  = new CompetidorJpaDAO();
		List<Competidor> cptdList;
		ObservableList<tvCompetidorController> listCompetidorTabela = FXCollections.observableArrayList();
		
		JuradoJpaDAO jrdDAO  = new JuradoJpaDAO();
		List<Jurado> jrdList;
		ObservableList<tvJuradoController> listJuradoTabela = FXCollections.observableArrayList();
		
		CompeticaoJpaDAO cptcDAO  = new CompeticaoJpaDAO();
		List<Competicao> cptcList;
		ObservableList<tvCompeticaoController> listCompeticaoTabela = FXCollections.observableArrayList();
		
		AvaliacaoJpaDAO avlDAO  = new AvaliacaoJpaDAO();
		List<Avaliacao> avlList;
		ObservableList<tvAvaliacaoController> listAvaliacaoTabela = FXCollections.observableArrayList();

		ObservableList<tvRankingMascController> listRankingMascTabela = FXCollections.observableArrayList();
		ObservableList<tvRankingFemController> listRankingFemTabela = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarCompetidores();
		carregarJuradosAvl();
		carregarAlunosAvl();
		carregarJurados();
		carregarCompeticoes();
		carregarAvaliacoes();
		carregarPart();
		carregarInst();
				
		tvCompetidor.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				igualar_textCptd();	
			}
		});
		
		tvJurado.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				igualar_textJrd();	
			}
		});
		
		tvCompeticao.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				igualar_textCptc();	
			}
		});
		
		tvAvaliacao.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				igualar_textAvl();	
			}
		});
	}

	@Override
	public void start(Stage menu) throws Exception {
		this.raiz = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
		menu.initStyle(StageStyle.DECORATED);
		
		menu.setMaximized(true);
		menu.setFullScreen(true);
		menu.setTitle("Festa da Primavera");
		        
        menu.getIcons().add(new Image(App.class.getResourceAsStream("iconLogin.png")));

		Scene scene = new Scene(raiz);
		menu.setScene(scene);
		menu.show();
	}
	
	//COMPETIDORES
	public void igualar_textCptd() {
		txbNomeCptd.setText(tvCompetidor.getSelectionModel().getSelectedItem().getNome());
		txbIdadeCptd.setText(tvCompetidor.getSelectionModel().getSelectedItem().getIdade().toString());
		if(tvCompetidor.getSelectionModel().getSelectedItem().getSexo().toString().equals("Masculino")) {
			rbMascCptd.setSelected(true);
		}else {
			rbFemCptd.setSelected(true);
		}
		
		int j=0;
		int tot_linhas = cmbInstituicaoCptd.getItems().size();
		while (j< tot_linhas) {
			if(cmbInstituicaoCptd.getItems().get(j).startsWith(tvCompetidor.getSelectionModel().getSelectedItem().getInstituicao().toString())) {
				cmbInstituicaoCptd.getSelectionModel().select(j);
				j = tot_linhas+1;
			}
			j++;
		}
		
		txbTurmaCptd.setText(tvCompetidor.getSelectionModel().getSelectedItem().getTurma().toString());
		txbTurmaCptd.setText(tvCompetidor.getSelectionModel().getSelectedItem().getTurma().toString());
		btnRegCptd.setText("Atualizar");
		lblCptd.setText(txbNomeCptd.getText()+" - RM #"+tvCompetidor.getSelectionModel().getSelectedItem().getRM());
		txbRMCptd.setText(tvCompetidor.getSelectionModel().getSelectedItem().getRM().toString());
	}
	

	@FXML
	public void carregarCompetidores() {
		if(!listCompetidorTabela.isEmpty()) {
			listCompetidorTabela.clear();
		}
		
		cptdList = cptdDAO.findAll();
		
		for(Competidor competidor: cptdList) {			
			tvCompetidorController c = new tvCompetidorController(competidor.getRm(), competidor.getNome(), competidor.getIdade(), competidor.getSexo(), competidor.getId_inst(), competidor.getTurma());
			listCompetidorTabela.add(c);
		}
		
		tcRMCptd.setCellValueFactory(new PropertyValueFactory<tvCompetidorController, Integer> ("RM"));
		tcNomeCptd.setCellValueFactory(new PropertyValueFactory<tvCompetidorController, String> ("nome"));
		tcIdadeCptd.setCellValueFactory(new PropertyValueFactory<tvCompetidorController, Integer> ("idade"));
		tcSexoCptd.setCellValueFactory(new PropertyValueFactory<tvCompetidorController, String> ("sexo"));
		tcInstituicaoCptd.setCellValueFactory(new PropertyValueFactory<tvCompetidorController, String> ("instituicao"));
		tcTurmaCptd.setCellValueFactory(new PropertyValueFactory<tvCompetidorController, String> ("turma"));
		
		tvCompetidor.setItems(listCompetidorTabela);
	}
	
	@FXML
	public void RegistrarCompetidor(ActionEvent event) throws Exception {
		if(validaCompetidor()) {
			Competidor cptd = new Competidor();
			cptd.setNome(txbNomeCptd.getText());
			cptd.setIdade(Integer.parseInt(txbIdadeCptd.getText()));
			String[] stringIdInst = cmbInstituicaoCptd.getValue().split(" ");
			cptd.setId_inst(Integer.parseInt(stringIdInst[0]));
			cptd.setTurma(txbTurmaCptd.getText());
			if(rbMascCptd.isSelected()) {
				cptd.setSexo("Masculino");
			}else {
				cptd.setSexo("Feminino");
			}
			
			CompetidorJpaDAO cptdDao = new CompetidorJpaDAO();
			if(btnRegCptd.getText().equals("Registrar")) {
				cptd.setRm(Integer.parseInt(txbRMCptd.getText()));
				cptdDAO.addCompetidor(cptd);
				
				Alert alert = new Alert(AlertType.WARNING, "", ButtonType.YES, ButtonType.NO);
				alert.setTitle("Cadastro de Participação");
				alert.setHeaderText("Inserir Participação");
				alert.initOwner((Stage) btnRegCptd.getScene().getWindow());
				alert.setContentText("Deseja inserir o competidor na Competição de "+LocalDate.now().getYear()+"?");
				Optional<ButtonType> resultado = alert.showAndWait();

				if (resultado.get() == ButtonType.YES) {
					Participacao ptcp = new Participacao();
					ptcp.setEdicao(LocalDate.now().getYear());
					ptcp.setRm(cptd.getRm());
					    
					ParticipacaoJpaDAO ptcpDAO = new ParticipacaoJpaDAO();
					ptcpDAO.addParticipacao(ptcp);
					carregarPart();
				}
			}else {    
				String[] stringID = lblCptd.getText().split("#");
				cptd.setRm(Integer.parseInt(stringID[1]));
				cptdDAO.updateCompetidor(cptd);
			}
			
			
			carregarCompetidores();
		}
	}
	
	@FXML
	public void ApagarCompetidor(ActionEvent event) throws Exception {
		CompetidorJpaDAO medDao = new CompetidorJpaDAO();
		medDao.removeCompetidor(tvCompetidor.getSelectionModel().getSelectedItem().getRM());
		carregarCompetidores();
	}
	
	@FXML
	public void NovoRegistroCompetidor(ActionEvent event) throws Exception {
		lblCptd.setText("Novo Competidor - RM #");
		LimparDadosCompetidor();
		rbMascCptd.setSelected(true);
		btnRegCptd.setText("Registrar");
	}
	
	public boolean validaCompetidor() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro");
		alert.setHeaderText("Campo não preenchido");
		alert.initOwner((Stage) btnRegCptd.getScene().getWindow());
		if(txbNomeCptd.getText().isEmpty()) {
			alert.setContentText("Preencha o campo de Nome para continuar.");
			alert.show();
			txbNomeCptd.requestFocus();
			return false;
		}else if(txbIdadeCptd.getText().contains(" ")) {
			alert.setContentText("Preencha o campo de Idade para continuar.");
			alert.show();
			txbIdadeCptd.requestFocus();
			return false;
		} else if(txbRMCptd.getText().isEmpty()) {
			alert.setContentText("Preencha o campo de RM para continuar.");
			alert.show();
			txbRMCptd.requestFocus();
			return false;
		} else if(txbTurmaCptd.getText().contains(" ")) {
			alert.setContentText("Preencha o campo de Turma para continuar.");
			alert.show();
			txbTurmaCptd.requestFocus();
			return false;
		}else {
			return true;
		}		
	}
	
	@FXML
	public void LimparDadosCompetidor(){
		txbNomeCptd.clear();
		txbIdadeCptd.clear();
		txbRMCptd.clear();
		txbTurmaCptd.clear();
		txbRMCptd.clear();
		rbMascCptd.setSelected(true);
	}
	
	@FXML
	public void regInst(){
		TextInputDialog dialog = new TextInputDialog("Nome da Instituição");
		dialog.initOwner((Stage) btnRegCptd.getScene().getWindow());
		dialog.setTitle("Cadastro de Instituição");
		dialog.setHeaderText("Nova Instituição");
		dialog.setContentText("Informe o nome da Instituição a ser adicionada:");
		
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
		    Instituicao inst = new Instituicao();
		    inst.setNome(result.get().toString());
		    
		    InstituicaoJpaDAO instDAO = new InstituicaoJpaDAO();
		    instDAO.addInstituicao(inst);
		    carregarInst();
		}
	}
	
	@FXML
	public void carregarInst(){
		cmbInstituicaoCptd.getItems().clear();
		InstituicaoJpaDAO instDAO = new InstituicaoJpaDAO();
		List<Instituicao> list = instDAO.findAll();
		ObservableList<Instituicao> ptcpList = FXCollections.observableList(list);
		for(Instituicao inst : ptcpList) {
			cmbInstituicaoCptd.getItems().add(inst.getId_inst()+" - "+inst.getNome());
		}
	}
	
	@FXML
	public void regPart(){
		Participacao ptcp = new Participacao();
		ptcp.setEdicao(Integer.parseInt(cmbPartCptd.getValue()));
		String[] stringRM = lblCptd.getText().split("#");
		ptcp.setRm(Integer.parseInt(stringRM[1]));
		    
		ParticipacaoJpaDAO ptcpDAO = new ParticipacaoJpaDAO();
		ptcpDAO.addParticipacao(ptcp);
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Cadastro de Participação");
		alert.setHeaderText("Inserção de Participação");
		alert.initOwner((Stage) btnRegCptd.getScene().getWindow());
		alert.setContentText("O Competidor selecionado foi adicionado à competição de "+cmbPartCptd.getValue()+"!");
		alert.show();
		
		carregarPart();
	}
	
	@FXML
	public void carregarPart(){
		cmbCvtJrd.getItems().clear();
		cmbPartCptd.getItems().clear();

		CompeticaoJpaDAO cptcDAO = new CompeticaoJpaDAO();
		List<Competicao> list = cptcDAO.findAll();
		ObservableList<Competicao> ptcpList = FXCollections.observableList(list);
		for(Competicao cptc : ptcpList) {
			cmbPartCptd.getItems().add(cptc.getEdicao().toString());
			cmbCvtJrd.getItems().add(cptc.getEdicao().toString());
		}
	}
	
	//JURADO
		public void igualar_textJrd() {
			txbNomeJurado.setText(tvJurado.getSelectionModel().getSelectedItem().getNome());
			txbOcupacaoJurado.setText(tvJurado.getSelectionModel().getSelectedItem().getOcupacao());
			txbLoginJurado.setText(tvJurado.getSelectionModel().getSelectedItem().getLogin());
			
			txbSenhaJurado.setText("");
			txbRepeteSenhaJurado.setText("");
			txbLoginJurado.setDisable(true);
			txbSenhaJurado.setDisable(true);
			txbRepeteSenhaJurado.setDisable(true);
			btnRegJurado.setText("Atualizar");
			lblJurado.setText(txbNomeJurado.getText()+" - ID #"+tvJurado.getSelectionModel().getSelectedItem().getLogin());
		}
		

		@FXML
		public void carregarJurados() {
			if(!listJuradoTabela.isEmpty()) {
				listJuradoTabela.clear();
			}
			
			jrdList = jrdDAO.findAll();
			
			for(Jurado jurado: jrdList) {			
				tvJuradoController c = new tvJuradoController(jurado.getNome(), jurado.getOcupacao(), jurado.getLogin());
				listJuradoTabela.add(c);
			}
			tcNomeJurado.setCellValueFactory(new PropertyValueFactory<tvJuradoController, String> ("nome"));
			tcOcupacaoJurado.setCellValueFactory(new PropertyValueFactory<tvJuradoController, String> ("ocupacao"));
			tcLoginJurado.setCellValueFactory(new PropertyValueFactory<tvJuradoController, String> ("login"));
			
			tvJurado.setItems(listJuradoTabela);
		}
		
		@FXML
		public void RegistrarJurado(ActionEvent event) throws Exception {
			int f;
			if(btnRegJurado.getText().equals("Registrar")) {
				f = 0;
			}else {
				f = 1;
			}
			if(validaJurado(f)) {
				Jurado jrd = new Jurado();
				jrd.setNome(txbNomeJurado.getText());
				jrd.setOcupacao(txbOcupacaoJurado.getText());
				
				//CRIPTOGRAFIA MD5 DA SENHA
				MessageDigest m=MessageDigest.getInstance("SHA-256");
			    m.update(txbSenhaJurado.getText().getBytes(),0, txbSenhaJurado.getText().length());
				
				jrd.setSenha(new BigInteger(1,m.digest()).toString(16));
				
				JuradoJpaDAO jrdDAO = new JuradoJpaDAO();
				if(btnRegJurado.getText().equals("Registrar")) {
					jrd.setLogin(txbLoginJurado.getText());
					jrdDAO.addJurado(jrd);
					
					Alert alert = new Alert(AlertType.WARNING, "", ButtonType.YES, ButtonType.NO);
					alert.setTitle("Cadastro de Convite");
					alert.setHeaderText("Inserir Convite");
					alert.initOwner((Stage) btnRegCptd.getScene().getWindow());
					alert.setContentText("Deseja inserir o jurado na Competição de "+LocalDate.now().getYear()+"?");
					Optional<ButtonType> resultado = alert.showAndWait();
					
					if(resultado.get() == ButtonType.YES) {
						Convite cvt = new Convite();
						cvt.setAno(LocalDate.now().getYear());
						String[] stringID = lblJurado.getText().split("#");
						cvt.setLogin(jrd.getLogin());
						    
						ConviteJpaDAO cvtDAO = new ConviteJpaDAO();
						cvtDAO.addConvite(cvt);
						carregarPart();
					}
					
				}else {    
					String[] stringID = lblJurado.getText().split("#");
					jrd.setLogin(stringID[1]);
					jrdDAO.updateJurado(jrd);
				}
				
				carregarJurados();
			}
		}
		
		@FXML
		public void ApagarJurado(ActionEvent event) throws Exception {
			JuradoJpaDAO jrdDao = new JuradoJpaDAO();
			jrdDao.removeJurado(tvJurado.getSelectionModel().getSelectedItem().getLogin());
			carregarJurados();
		}
		
		@FXML
		public void NovoRegistroJurado(ActionEvent event) throws Exception {
			lblJurado.setText("Novo Jurado - ID #");
			LimparDadosJurado();
			txbLoginJurado.setDisable(false);
			txbSenhaJurado.setDisable(false);
			txbRepeteSenhaJurado.setDisable(false);
			btnRegJurado.setText("Registrar");
		}
		
		public boolean validaJurado(int flag) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro");
			alert.setHeaderText("Campo não preenchido");
			alert.initOwner((Stage) btnRegJurado.getScene().getWindow());
			if(txbNomeJurado.getText().isEmpty()) {
				alert.setContentText("Preencha o campo de Nome para continuar.");
				alert.show();
				txbNomeJurado.requestFocus();
				return false;
			}else if(txbOcupacaoJurado.getText().isEmpty()) {
				alert.setContentText("Preencha o campo de Ocupação para continuar.");
				alert.show();
				txbOcupacaoJurado.requestFocus();
				return false;
			} else if(txbLoginJurado.getText().isEmpty()) {
				alert.setContentText("Preencha o campo de Login para continuar.");
				alert.show();
				txbLoginJurado.requestFocus();
				return false;
			} else if(txbSenhaJurado.getText().isEmpty() && flag == 0) {
				alert.setContentText("Preencha o campo de Senha para continuar.");
				alert.show();
				txbSenhaJurado.requestFocus();
				return false;
			} else if(txbRepeteSenhaJurado.getText().isEmpty() && flag == 0) {
				alert.setContentText("Digite novamente a Senha para confirmá-la.");
				alert.show();
				txbRepeteSenhaJurado.requestFocus();
				return false;
			} else if(!txbSenhaJurado.getText().equals(txbRepeteSenhaJurado.getText()) && flag == 0) {
				alert.setContentText("As senhas digitadas não são correspondentes.");
				alert.show();
				txbSenhaJurado.requestFocus();
				return false;
			}else {
				return true;
			}		
		}
		
		@FXML
		public void LimparDadosJurado(){
			txbNomeJurado.clear();
			txbOcupacaoJurado.clear();
			txbLoginJurado.clear();
			txbSenhaJurado.clear();
			txbRepeteSenhaJurado.clear();
		}
		
		@FXML
		public void regCvt(){
			Convite cvt = new Convite();
			cvt.setAno(Integer.parseInt(cmbCvtJrd.getValue()));
			String[] stringID = lblJurado.getText().split("#");
			cvt.setLogin(stringID[1]);
			    
			ConviteJpaDAO cvtDAO = new ConviteJpaDAO();
			cvtDAO.addConvite(cvt);
			carregarPart();
		}
		
		@FXML
		public void regConv(){
			Convite cvt = new Convite();
			cvt.setAno(Integer.parseInt(cmbCvtJrd.getValue()));
			String[] stringID = lblJurado.getText().split("#");
			cvt.setLogin(stringID[1]);
			    
			ConviteJpaDAO cvtDAO = new ConviteJpaDAO();
			cvtDAO.addConvite(cvt);
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Cadastro de Participação");
			alert.setHeaderText("Inserção de Participação");
			alert.initOwner((Stage) btnRegCptd.getScene().getWindow());
			alert.setContentText("O Jurado selecionado foi adicionado à competição de "+cmbCvtJrd.getValue()+"!");
			alert.show();
			
			carregarPart();
		}
		
		//COMPETICAO
		public void igualar_textCptc() {
			txbEdicaoCptc.setText(tvCompeticao.getSelectionModel().getSelectedItem().getEdicao().toString());
			txbMrVCptc.setText(tvCompeticao.getSelectionModel().getSelectedItem().getRm_Mister().toString());
			txbMsVCptc.setText(tvCompeticao.getSelectionModel().getSelectedItem().getRm_Miss().toString());
			txbCriteriosCptc.setText(tvCompeticao.getSelectionModel().getSelectedItem().getCriterios().trim());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			dtpDataCptc.setValue(LocalDate.parse(tvCompeticao.getSelectionModel().getSelectedItem().getData(), formatter));
			
			btnRegCptc.setText("Atualizar");
			lblCompeticao.setText("Festa da Primavera - Edição #"+tvCompeticao.getSelectionModel().getSelectedItem().getEdicao());
		}
		

		@FXML
		public void carregarCompeticoes() {
			if(!listCompeticaoTabela.isEmpty()) {
				listCompeticaoTabela.clear();
			}
			
			cptcList = cptcDAO.findAll();
			
			for(Competicao cptc: cptcList) {			
				tvCompeticaoController c = new tvCompeticaoController(cptc.getEdicao(), cptc.getData(), cptc.getCriterios(), cptc.getRm_mister(), cptc.getRm_miss());
				listCompeticaoTabela.add(c);
			}
			
			tcEdicaoCptc.setCellValueFactory(new PropertyValueFactory<tvCompeticaoController, Integer> ("edicao"));
			tcDataCptc.setCellValueFactory(new PropertyValueFactory<tvCompeticaoController, String> ("data"));
			tcCriteriosCptc.setCellValueFactory(new PropertyValueFactory<tvCompeticaoController, String> ("criterios"));
			tcRmMisterCptc.setCellValueFactory(new PropertyValueFactory<tvCompeticaoController, Integer> ("Rm_Mister"));
			tcRmMissCptc.setCellValueFactory(new PropertyValueFactory<tvCompeticaoController, Integer> ("Rm_Miss"));
			
			tvCompeticao.setItems(listCompeticaoTabela);
		}
		
		@FXML
		public void RegistrarCompeticao(ActionEvent event) throws Exception {
			if(validaCompeticao()) {
				Competicao cptc = new Competicao();
				cptc.setEdicao(Integer.parseInt(txbEdicaoCptc.getText()));
				cptc.setData(dtpDataCptc.getValue().toString());
				cptc.setCriterios(txbCriteriosCptc.getText());
				
				CompeticaoJpaDAO cptcDao = new CompeticaoJpaDAO();
				if(btnRegCptc.getText().equals("Registrar")) {
					cptcDao.addCompeticao(cptc);
				}else {
					cptcDao.updateCompeticao(cptc);
				}
				
				carregarCompeticoes();
				carregarPart();
			}
		}
		
		@FXML
		public void ApagarCompeticao(ActionEvent event) throws Exception {
			CompeticaoJpaDAO cptcDao = new CompeticaoJpaDAO();
			cptcDao.removeCompeticao(tvCompeticao.getSelectionModel().getSelectedItem().getEdicao());
			carregarCompeticoes();
		}
		
		@FXML
		public void NovoRegistroCompeticao(ActionEvent event) throws Exception {
			lblCptd.setText("Nova Competição - Edição #");
			btnRegCptd.setText("Registrar");
		}
		
		public boolean validaCompeticao() {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro");
			alert.setHeaderText("Campo não preenchido");
			alert.initOwner((Stage) btnRegCptc.getScene().getWindow());
			if(txbEdicaoCptc.getText().isEmpty() || txbEdicaoCptc.getText().length() < 4) {
				alert.setContentText("Preencha o campo de Ano da Edição para continuar.");
				alert.show();
				txbEdicaoCptc.requestFocus();
				return false;
			}else if((txbCriteriosCptc.getText().contains(" ") && !txbCriteriosCptc.getText().contains(",")) || (txbCriteriosCptc.getText().isEmpty())) {
				alert.setContentText("Preencha o campo de Critérios para continuar, certifique-se de que está utilizando vírgulas para separar os critérios.");
				alert.show();
				txbCriteriosCptc.requestFocus();
				return false;
			} else {
				return true;
			}		
		}
		
		public void NovoRegistroCompeticao() {
			txbEdicaoCptc.clear();
			txbCriteriosCptc.clear();
			dtpDataCptc.setValue(LocalDate.now());
		}
		
		@FXML
		public void gerarRanking() {
			Competicao cptc = new Competicao();
			if(!listRankingMascTabela.isEmpty()) {
				listRankingMascTabela.clear();
			}
			if(!txbEdicaoCptc.getText().equals("")) {
				Session session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				Query q = session.createQuery("select c.rm, c.nome, AVG(a.pontuacao) as m from Avaliacao a  inner join Participacao p on p.rm = a.rm inner JOIN Competidor c on c.rm = a.rm WHERE p.edicao = "+txbEdicaoCptc.getText()+" AND c.sexo='Masculino' group by a.rm  order by m desc");
								
				List<Object[]> alunosRkg = (List<Object[]>)q.list();
				int i =1;
			    for(Object[] aluno: alunosRkg){
					tvRankingMascController a = new tvRankingMascController(i, Integer.parseInt(aluno[0].toString()), aluno[1].toString(), Double.parseDouble(aluno[2].toString()));
					listRankingMascTabela.add(a);
					if(i==1) {
						cptc.setRm_mister(Integer.parseInt(aluno[0].toString()));
						cptc.setRm_mister(Integer.parseInt(aluno[0].toString()));
					}
					i++;
			    }
			    
			    
				session.getTransaction().commit();
				session.close();
				
				tcPosMascCptc.setCellValueFactory(new PropertyValueFactory<tvRankingMascController, Integer> ("Posicao"));
				tcRmMascCptc.setCellValueFactory(new PropertyValueFactory<tvRankingMascController, Integer> ("RM"));
				tcNomeMascCptc.setCellValueFactory(new PropertyValueFactory<tvRankingMascController, String> ("nome"));
				tcPontuacaoMascCptc.setCellValueFactory(new PropertyValueFactory<tvRankingMascController, Double> ("pontuacao"));
				
				tvRankingMasc.setItems(listRankingMascTabela);
			}
			
			if(!listRankingFemTabela.isEmpty()) {
				listRankingFemTabela.clear();
			}
			if(!txbEdicaoCptc.getText().equals("")) {
				Session session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				Query q = session.createQuery("select c.rm, c.nome, AVG(a.pontuacao) as m from Avaliacao a  inner join Participacao p on p.rm = a.rm inner JOIN Competidor c on c.rm = a.rm WHERE p.edicao = "+txbEdicaoCptc.getText()+" AND c.sexo='Feminino' group by a.rm  order by m desc");
								
				List<Object[]> alunosRkg = (List<Object[]>)q.list();
				int i =1;
			    for(Object[] aluno: alunosRkg){
					tvRankingFemController a = new tvRankingFemController(i, Integer.parseInt(aluno[0].toString()), aluno[1].toString(), Double.parseDouble(aluno[2].toString()));
					listRankingFemTabela.add(a);
					if(i==1) {
						cptc.setRm_miss(Integer.parseInt(aluno[0].toString()));
					}
					i++;
			    }
			    cptc.setCriterios(txbCriteriosCptc.getText());
			    cptc.setData(dtpDataCptc.getValue().toString());
			    cptc.setEdicao(Integer.parseInt(txbEdicaoCptc.getText()));
			    CompeticaoJpaDAO cptcDAO = new CompeticaoJpaDAO();
			    cptcDAO.updateCompeticao(cptc);
			    
			    txbMrVCptc.setText(cptc.getRm_mister()+"");
			    txbMsVCptc.setText(cptc.getRm_miss()+"");
			    
				session.getTransaction().commit();
				session.close();
				
				tcPosFemCptc.setCellValueFactory(new PropertyValueFactory<tvRankingFemController, Integer> ("Posicao"));
				tcRmFemCptc.setCellValueFactory(new PropertyValueFactory<tvRankingFemController, Integer> ("RM"));
				tcNomeFemCptc.setCellValueFactory(new PropertyValueFactory<tvRankingFemController, String> ("nome"));
				tcPontuacaoFemCptc.setCellValueFactory(new PropertyValueFactory<tvRankingFemController, Double> ("pontuacao"));
				
				tvRankingFem.setItems(listRankingFemTabela);
			}
			
			carregarCompeticoes();
		}
		
		//AVALIAÇÃO
		public void igualar_textAvl() {
			int j=0;
			int tot_linhas = cmbJuradoAvl.getItems().size();
			while (j< tot_linhas) {
				if(cmbJuradoAvl.getItems().get(j).startsWith(tvAvaliacao.getSelectionModel().getSelectedItem().getLogin())) {
					cmbJuradoAvl.getSelectionModel().select(j);
					j = tot_linhas+1;
				}
				j++;
			}

			j=0;
			tot_linhas = cmbAlunoAvl.getItems().size();
			while (j< tot_linhas) {
				if(cmbAlunoAvl.getItems().get(j).startsWith(tvAvaliacao.getSelectionModel().getSelectedItem().getRm().toString())) {
					cmbAlunoAvl.getSelectionModel().select(j);
					j = tot_linhas+1;
				}
				j++;
			}
			
			lblAvl.setText("Avaliação - ID #"+tvAvaliacao.getSelectionModel().getSelectedItem().getIdAvaliacao());
		}
		

		@FXML
		public void carregarAvaliacoes() {
			if(!listAvaliacaoTabela.isEmpty()) {
				listAvaliacaoTabela.clear();
			}	
			
			avlList = avlDAO.findAll();
			
			for(Avaliacao av: avlList) {
				tvAvaliacaoController a = new tvAvaliacaoController(av.getIdAval(), av.getRm(), av.getLogin(), av.getPontuacao());
				listAvaliacaoTabela.add(a);
			}
			
			tcID_Avaliacao_Avl.setCellValueFactory(new PropertyValueFactory<tvAvaliacaoController, Integer> ("IdAvaliacao"));
			tcRM_Avl.setCellValueFactory(new PropertyValueFactory<tvAvaliacaoController, Integer> ("Rm"));
			tcID_Jurado_Avl.setCellValueFactory(new PropertyValueFactory<tvAvaliacaoController, String> ("Login"));
			tc_Pontuacao_Avl.setCellValueFactory(new PropertyValueFactory<tvAvaliacaoController, Double> ("Pontuacao"));
			
			tvAvaliacao.setItems(listAvaliacaoTabela);
		}
		
		@FXML
		public void ApagarAvaliacao(ActionEvent event) throws Exception {
			AvaliacaoJpaDAO avlDao = new AvaliacaoJpaDAO();
			avlDao.removeAvaliacao(tvAvaliacao.getSelectionModel().getSelectedItem().getIdAvaliacao());
			carregarAvaliacoes();
		}
		
		@FXML
		public void carregarAlunosAvl(){
			cmbAlunoAvl.getItems().clear();

			CompetidorJpaDAO cptdDAO = new CompetidorJpaDAO();
			List<Competidor> list = cptdDAO.findAll();
			ObservableList<Competidor> cptdList = FXCollections.observableList(list);
			for(Competidor cptd : cptdList) {
				cmbAlunoAvl.getItems().add(cptd.getRm()+ " - "+cptd.getNome());
			}
		}
		
		@FXML
		public void carregarJuradosAvl(){
			cmbJuradoAvl.getItems().clear();

			JuradoJpaDAO jrdDAO = new JuradoJpaDAO();
			List<Jurado> list = jrdDAO.findAll();
			ObservableList<Jurado> jrdList = FXCollections.observableList(list);
			for(Jurado jrd : jrdList) {
				cmbJuradoAvl.getItems().add(jrd.getLogin()+ " - "+jrd.getNome());
			}
		}
}

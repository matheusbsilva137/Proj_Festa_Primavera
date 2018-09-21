package controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Jurado;
import view.App;

public class LoginController extends Application{
	
	private double xOffset = 0, yOffset = 0;
	Label lblEsqSenha, lblLogin, lblVersao;

	@FXML
	JFXButton btnLogin;
	@FXML
	public JFXTextField txbUsername;
	@FXML
	JFXPasswordField txbSenha;
	
	private boolean adm = false;
	
	Stage stagePrim;
	Jurado jrd = new Jurado();
	
	@Override
	public void start(final Stage stagePrim) throws Exception {
		try {
            AnchorPane raiz = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
            this.stagePrim = stagePrim;
            
            
            stagePrim.setResizable(false);
            stagePrim.setWidth(349);
            stagePrim.setHeight(367);
            stagePrim.initStyle(StageStyle.TRANSPARENT);
            stagePrim.setTitle("Login");

            stagePrim.getIcons().add(new Image(App.class.getResourceAsStream("iconLogin.png")));
            
            raiz.setOnMousePressed(new EventHandler<MouseEvent>() {
            	public void handle(MouseEvent event) {
            		xOffset = event.getSceneX();
            		yOffset = event.getSceneY();
            	}
            });
            
            raiz.setOnMouseDragged(new EventHandler<MouseEvent>() {
            	public void handle(MouseEvent event) {
            		stagePrim.setX(event.getScreenX() - xOffset);
            		stagePrim.setY(event.getScreenY() - yOffset);            		
            	}
            });
            
            Scene scene = new Scene(raiz);
            stagePrim.setScene(scene);
            stagePrim.show();
            
        }catch(Exception e) {
            e.printStackTrace();
        }		
	}
	
	public boolean verificarLogin(String login, String senha) throws NoSuchAlgorithmException{
		boolean val = false;
		//CRIPTOGRAFIA SHA-256 DA SENHA
		MessageDigest m=MessageDigest.getInstance("SHA-256");
	    m.update(txbSenha.getText().getBytes(),0, txbSenha.getText().length());
		
		senha = (new BigInteger(1,m.digest()).toString(16));
		
		if(login.equals("ADM")) {
			if(senha.equals("227586418f0f0bafd34b5e3fc1139369d950dc575531093c386a7628e15cf8ac")) {
				adm = true;
				return val = true;
			}else { 
				adm = false;
				return val = false;
			}
		}else {
			adm = false;
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			String sql = String.format("SELECT COUNT(*) FROM jurado WHERE login = '%s' AND senha = '%s';",login, senha);
			SQLQuery query = session.createSQLQuery(sql);
			List result = query.list();
			session.getTransaction().commit();
			session.close();
			
			System.out.println(result.get(0));
			if(Integer.parseInt(result.get(0).toString()) == 1) {
				return val =  true;
			}
			else {
				return val =  false;
			}
		}
	}
	
	@FXML
	public void login(ActionEvent event) throws Exception {
		boolean login = verificarLogin(txbUsername.getText(), txbSenha.getText());
		Stage stageAtual = (Stage) btnLogin.getScene().getWindow();
		
    	if(adm == true) {  		
    		MenuController menu = new MenuController();
			Stage stage = new Stage();
			menu.start(stage);
			stageAtual.close();
    	}
    	else if (login == true) {
    		MenuJuradoController menuj = new MenuJuradoController();
    		menuj.setLoginAtual(txbUsername.getText());
			Stage stagej = new Stage();
			menuj.start(stagej);
			
			stageAtual.close();
    	}
    	else {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Login Inválido");
    		alert.setHeaderText("Login ou Senha Inválidos");
			alert.initOwner((Stage) txbUsername.getScene().getWindow());
    		alert.setContentText("O nome de usuário e senha informados não correspondem a nenhum usuário cadastrado no sistema.");
    		alert.show();
    		txbUsername.clear();
    		txbSenha.clear();
    		txbUsername.requestFocus();
    	}
	}
}
package controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class tvAvaliacaoController {
	private final SimpleIntegerProperty rm;
	private final SimpleIntegerProperty id_avaliacao;
	private final SimpleStringProperty login;
	private final SimpleDoubleProperty pontuacao;
		
	public tvAvaliacaoController(int id_avaliacao, int rm, String login, double pontuacao) {
		super();
		
		this.id_avaliacao = new SimpleIntegerProperty(id_avaliacao);
		this.rm = new SimpleIntegerProperty(rm);
		this.login = new SimpleStringProperty(login);
		this.pontuacao = new SimpleDoubleProperty(pontuacao);
	}
		
	public Integer getRm() {
		return rm.get();
	}
		
	public Integer getIdAvaliacao() {
		return id_avaliacao.get();
	}
	
	public String getLogin() {
		return login.get();
	}
		
	public Double getPontuacao() {
		return pontuacao.get();
	}
	
}

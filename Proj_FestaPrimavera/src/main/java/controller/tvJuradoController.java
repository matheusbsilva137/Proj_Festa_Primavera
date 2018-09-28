package controller;

import javafx.beans.property.SimpleStringProperty;

public class tvJuradoController {
	private final SimpleStringProperty nome;
	private final SimpleStringProperty ocupacao;
	private final SimpleStringProperty login;
		
	public tvJuradoController(String nome, String ocupacao, String login) {
		super();
			
		this.nome = new SimpleStringProperty(nome);
		this.ocupacao = new SimpleStringProperty(ocupacao);
		this.login = new SimpleStringProperty(login);
	}
		
	public String getNome() {
		return nome.get();
	}
		
	public String getOcupacao() {
		return ocupacao.get();
	}
		
	public String getLogin() {
		return login.get();
	}
}
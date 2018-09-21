package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Jurado")
public class Jurado {
	@Id
	private String login;
	@Column
	private String nome;
	@Column
	private String ocupacao;	
	@Column
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getOcupacao() {
		return ocupacao;
	}
	public void setOcupacao(String ocupacao){
		this.ocupacao = ocupacao;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String username){
		this.login = username;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha){
		this.senha = senha; 
	}
}

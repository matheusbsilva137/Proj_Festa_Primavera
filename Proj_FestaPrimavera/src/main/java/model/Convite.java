package model;

import javax.persistence.*;
@Entity
@Table (name = "Convite")
public class Convite {
	@Id
	private int id_convite;
	@Column 
	private int ano;
	@Column
	private String login;
	
	public int getIdConv() {
		return id_convite;
	}
	public void setIdConv(int id_convite){
		
		this.id_convite = id_convite;
	}
		
	public Integer getAno() {
		return ano;
	}
	public void setAno(int ano){
		this.ano = ano;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login){
		this.login = login;
	}
}

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Avaliacao")

public class Avaliacao {
	@Id
	private int id_avaliacao;
	@Column
	private String login;
	@Column
	private int rm;
	@Column
	private String notas;
	@Column
	private double pontuacao;
	
	public int getIdAval() {
		return id_avaliacao;
	}
	public void setIdAval(int id_avaliacao){
		
		this.id_avaliacao = id_avaliacao;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login){
		this.login = login;
	}
	public int getRm() {
		return rm;
	}
	public void setRm(int rm){
		this.rm = rm;
	}
	public String getNotas() {
		return notas;
	}
	public void setNotas(String notas){
		this.notas = notas;
	}
	public double getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(double pontuacao){
		
		this.pontuacao = pontuacao;
	}
}
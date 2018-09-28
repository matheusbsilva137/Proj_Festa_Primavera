package model;

import javax.persistence.*;

@Entity
@Table (name = "Participacao")
public class Participacao {
	@Id
	private int id_participacao;
	@Column 
	private int edicao;
	@Column
	private int rm;
	
	public int getIdPart() {
		return id_participacao;
	}
	public void setIdPart(int id_participacao){
		
		this.id_participacao = id_participacao;
	}
		
	public Integer getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao){
		this.edicao = edicao;
	}

	public int getRm() {
		return rm;
	}
	public void setRm(int rm){
		this.rm = rm;
	}
}

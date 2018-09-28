package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Instituicao")
public class Instituicao {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_inst;
	@Column
	private String nome;
	
	public int getId_inst() {
		return id_inst;
	}
	public void setId_inst(int id_inst){
		this.id_inst = id_inst;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome (String nome){
		this.nome = nome;
	}
}

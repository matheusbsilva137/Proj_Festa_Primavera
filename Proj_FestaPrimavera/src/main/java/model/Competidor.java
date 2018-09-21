package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Competidor {
	@Id
	private int rm;
	@Column
	private String nome;
	@Column
	private String turma;
	@Column
	private int idade;
	@Column
	private String sexo;
	@Column
	private int id_inst;
	
	public int getRm() {
		return rm;
	}
	public void setRm(int rm){
		this.rm = rm;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma){
		this.turma = turma;
	}
	
	public String getSexo(){
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade){
		this.idade = idade;
	}
	
	public int getId_inst() {
		return id_inst;
	}
	public void setId_inst(int id_inst){
		this.id_inst = id_inst;
	}
}

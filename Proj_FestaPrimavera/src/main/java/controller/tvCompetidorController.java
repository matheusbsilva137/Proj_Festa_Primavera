package controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class tvCompetidorController{
	private final SimpleIntegerProperty rm;
	private final SimpleStringProperty nome;
	private final SimpleIntegerProperty idade;
	private final SimpleStringProperty sexo;
	private final SimpleIntegerProperty inst;
	private final SimpleStringProperty turma;
	
	public tvCompetidorController(int rm, String nome, int idade, String sexo, int id_inst, String turma) {
		super();
		
		this.rm = new SimpleIntegerProperty(rm);
		this.nome = new SimpleStringProperty(nome);
		this.idade = new SimpleIntegerProperty(idade);
		this.sexo = new SimpleStringProperty(sexo);
		this.inst = new SimpleIntegerProperty(id_inst);
		this.turma = new SimpleStringProperty(turma);
	}
	
	public Integer getRM() {
		return rm.get();
	}
	
	public String getNome() {
		return nome.get();
	}
	
	public Integer getIdade() {
		return idade.get();
	}
	
	public String getSexo() {
		return sexo.get();
	}
	
	public Integer getInstituicao() {
		return inst.get();
	}
	
	public String getTurma() {
		return turma.get();
	}
}

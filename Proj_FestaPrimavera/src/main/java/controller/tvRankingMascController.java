package controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class tvRankingMascController{
	private final SimpleIntegerProperty posicao;
	private final SimpleIntegerProperty rm;
	private final SimpleStringProperty nome;
	private final SimpleDoubleProperty pontuacao;
	
	public tvRankingMascController(int posicao, int rm, String nome, double pontuacao) {
		super();
		
		this.posicao = new SimpleIntegerProperty(posicao);
		this.rm = new SimpleIntegerProperty(rm);
		this.nome = new SimpleStringProperty(nome);
		this.pontuacao = new SimpleDoubleProperty(pontuacao);
	}
	
	public Integer getPosicao() {
		return posicao.get();
	}
	
	public Integer getRM() {
		return rm.get();
	}
	
	public String getNome() {
		return nome.get();
	}
	
	public double getPontuacao() {
		return pontuacao.get();
	}
	
}

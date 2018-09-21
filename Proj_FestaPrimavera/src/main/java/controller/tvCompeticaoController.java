package controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class tvCompeticaoController {
	private final SimpleIntegerProperty edicao;
	private final SimpleStringProperty data;
	private final SimpleIntegerProperty rm_miss;
	private final SimpleIntegerProperty rm_mister;
	private final SimpleStringProperty criterios;
		
	public tvCompeticaoController(int edicao, String data, String criterios, int rm_mister, int rm_miss) {
		super();
			
		this.data = new SimpleStringProperty(data);
		this.criterios = new SimpleStringProperty(criterios);
		this.edicao = new SimpleIntegerProperty(edicao);
		this.rm_mister = new SimpleIntegerProperty(rm_mister);
		this.rm_miss = new SimpleIntegerProperty(rm_miss);
	}
		
	public Integer getEdicao() {
		return edicao.get();
	}
		
	public String getData() {
		return data.get();
	}
	
	public String getCriterios() {
		return criterios.get();
	}
		
	public Integer getRm_Miss() {
		return rm_miss.get();
	}
	
	public Integer getRm_Mister() {
		return rm_mister.get();
	}
}

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Competicao")
public class Competicao {
	@Id
	private int edicao;
	//rm dos vencedores
	@Column
	private int rm_miss;
	@Column
	private int rm_mister;
	@Column
	private String data;
	@Column
	private String criterios;
	
	public Integer getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao){
		this.edicao = edicao;
	}
	
	public int getRm_miss() {
		return rm_miss;
	}
	public void setRm_miss(int rm_miss){
		this.rm_miss = rm_miss;
	}
	
	public int getRm_mister() {
		return rm_mister;
	}
	public void setRm_mister(int rm_mister){
		this.rm_mister = rm_mister;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data){
		this.data = data;
	}
	
	public String getCriterios() {
		return criterios;
	}
	public void setCriterios(String criterios){
		this.criterios = criterios;
	}
}

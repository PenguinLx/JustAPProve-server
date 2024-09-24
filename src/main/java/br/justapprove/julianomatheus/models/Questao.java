package br.justapprove.julianomatheus.models;

import java.io.File;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Questao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private File descricao;
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<Alternativa> alternativas;
	
	
	public File getDescricao() {
		return descricao;
	}
	public void setDescricao(File descricao) {
		this.descricao = descricao;
	}
	public List<Alternativa> getAlternativas() {
		return alternativas;
	}
	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}
	
	

}

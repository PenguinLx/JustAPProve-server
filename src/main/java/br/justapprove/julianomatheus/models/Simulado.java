package br.justapprove.julianomatheus.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
public class Simulado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToMany
	@JoinColumn(name = "id")
	@Getter @Setter private List<Questao> questoes;

	@Getter @Setter private int pontos;

//	public List<Questao> getQuestoes() {
//		return questoes;
//	}
//
//	public void setQuestoes(List<Questao> questoes) {
//		this.questoes = questoes;
//	}
//
//	public int getPontos() {
//		return pontos;
//	}
//
//	public void setPontos(int pontos) {
//		this.pontos = pontos;
//	}

}

package br.justapprove.julianomatheus.models;

import java.util.List;

import org.hibernate.annotations.JavaType;

import br.justapprove.julianomatheus.TipoMateria;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Materia {
/*
 * quando abrir a tela de matérias, o usuario poderá escolher qual vai querer e quando escolher poderá ver os materiais da matéria escolhida
 */
	//problema de tipo - possivel soluçao = https://stackoverflow.com/questions/67825729/using-enums-in-a-spring-entity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	protected String nome;
	protected String descricao;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TipoMat")
	protected TipoMateria tipo;
	//UMA MATERIA, MUITOS MATERIAIS(ONE TO MANY)
	@OneToMany
	@JoinColumn(name = "id")
	protected List<Material> materiais;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public TipoMateria getTipo() {
		return tipo;
	}
	public void setTipo(TipoMateria tipo) {
		this.tipo = tipo;
	}
	
	
	
}

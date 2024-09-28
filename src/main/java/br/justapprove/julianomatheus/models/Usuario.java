package br.justapprove.julianomatheus.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private Integer id;
	
	@Getter @Setter private String cpf;
	@Getter @Setter private String senha;
	@Getter @Setter private int ponto;
	@Getter @Setter private String nome;
	
//	public String getCpf() {
//		return cpf;
//	}
//	public void setCpf(String cpf) {
//		this.cpf = cpf;
//	}
//	public String getSenha() {
//		return senha;	
//	}
//	public void setSenha(String senha) {
//		this.senha = senha;
//	}
//	public int getPonto() {
//		return ponto;
//	}
//	public void setPonto(int ponto) {
//		this.ponto = ponto;
//	}
//	public String getNome() {
//		return nome;
//	}
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
	
	
	

}

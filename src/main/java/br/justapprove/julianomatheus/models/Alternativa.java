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
public class Alternativa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private Integer id;
	
	@Getter @Setter private boolean correta;
	
	@Getter @Setter private String descricao;
	
	
//	public String getDescricao() {
//		return descricao;
//	}
//	public void setDescricao(String descricao) {
//		this.descricao = descricao;
//	}
//	public boolean isCorreta() {
//		return correta;
//	}
//	public void setCorreta(boolean correta) {
//		this.correta = correta;
//	}
	
	
}

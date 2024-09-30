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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
public class Questao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private Integer id;
	@Getter @Setter private File descricao;
	
	@OneToMany
	@JoinColumn(name = "id")
	@Getter @Setter private List<Alternativa> alternativas;
	

	

}

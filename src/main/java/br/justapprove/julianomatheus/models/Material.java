package br.justapprove.julianomatheus.models;

import java.io.File;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
public class Material {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private Integer id;
	
	@Getter @Setter private String artigo;
	@Lob @Getter @Setter private byte[] video;
	//https://stackoverflow.com/questions/65655237/spring-boot-making-another-entity-class-object-in-entity-class
	@ManyToOne
	@JoinColumn(name = "id_materia")
	private Materia materia;
	
}

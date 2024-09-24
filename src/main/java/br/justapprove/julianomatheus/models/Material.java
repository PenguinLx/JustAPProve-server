package br.justapprove.julianomatheus.models;

import java.io.File;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Material {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String artigo;
	private File video;
	//https://stackoverflow.com/questions/65655237/spring-boot-making-another-entity-class-object-in-entity-class
	
	//private Materias materia;
	
	public String getArtigo() {
		return artigo;
	}
	public void setArtigo(String artigo) {
		this.artigo = artigo;
	}
	public File getVideo() {
		return video;
	}
	public void setVideo(File video) {
		this.video = video;
	}
	
	
	
	
	
	
}

package br.justapprove.julianomatheus.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Entity
//@Builder
public class ProvaAnterior {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private Integer id;
	
	@Getter @Setter private String titulo;
	@Lob
	@Column(columnDefinition = "mediumblob")
	@Getter @Setter private byte[] pdf;
	
	
	
	
}

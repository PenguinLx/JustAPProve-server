package br.justapprove.julianomatheus.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;
@Entity
public class ProvaAnterior {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private Integer id;
	
	@Getter @Setter private String titulo;
	@Lob
	@Getter @Setter private byte[] pdf;
	
	
	
	
}

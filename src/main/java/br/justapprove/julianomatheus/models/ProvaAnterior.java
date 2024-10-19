package br.justapprove.julianomatheus.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class ProvaAnterior {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private Integer id;
	
	@Getter @Setter private String titulo;
	@Lob
	@Column(columnDefinition = "mediumblob")
	@Getter @Setter private byte[] pdf;
	
	
	
	
}

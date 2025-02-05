package br.justapprove.julianomatheus.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Material {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private Integer id;
	
	@Getter @Setter private String descricao;

	@Column(columnDefinition = "mediumtext")
	@Lob @Getter @Setter private String videoEmbedd;
	//https://stackoverflow.com/questions/65655237/spring-boot-making-another-entity-class-object-in-entity-class
	@JsonIgnore
	@OneToOne(mappedBy = "material")
    //@JoinColumn(name = "materia_id")
	@Getter @Setter private Materia materia;
	
	
	
	
	
}

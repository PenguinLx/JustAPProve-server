package br.justapprove.julianomatheus.models;

import java.util.List;

import org.hibernate.annotations.JavaType;

import jakarta.persistence.CascadeType;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Materia {
/*
 * quando abrir a tela de matérias, o usuario poderá escolher qual vai querer e quando escolher poderá ver os materiais da matéria escolhida
 */
	//problema de tipo - possivel soluçao = https://stackoverflow.com/questions/67825729/using-enums-in-a-spring-entity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private Integer id;
	
	@Getter @Setter private String nome;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TipoMat")
	@Getter @Setter private TipoMateria tipo;
	//UMA MATERIA, MUITOS MATERIAIS(ONE TO MANY)
	@OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, orphanRemoval = true)
	@Getter @Setter private List<Material> materiais;
}


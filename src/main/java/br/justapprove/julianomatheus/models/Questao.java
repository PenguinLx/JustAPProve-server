package br.justapprove.julianomatheus.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.justapprove.julianomatheus.util.JsonCollectionDeserializer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
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
public class Questao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private Integer id;
	@Column(columnDefinition = "mediumblob")
	@Lob @Getter @Setter private byte[] descricao;
	
	@OneToMany(mappedBy = "questao")
	@JsonProperty("list")
	//using = JsonCollectionDeserializer.class
	@JsonDeserialize(as=List.class, contentAs=Alternativa.class)
	@Getter @Setter private List<Alternativa> alternativas;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(
			name="questao_simulado",
			joinColumns= @JoinColumn(name="questao_id"),
			inverseJoinColumns = @JoinColumn(name="simulado_id")
			)
	private Set<Simulado> simulados = new HashSet<>();
	

}

package br.justapprove.julianomatheus.models;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private Integer id;
	@Column(unique = true)
	@Getter @Setter private String email;
	@Getter @Setter private String senha;
	@Getter @Setter private String token;
	@Getter @Setter private int pontos;
	@Column(unique = true)
	@Getter	@Setter	private String apelido;
	  @Column(columnDefinition = "TIMESTAMP")
	   @Getter @Setter private LocalDateTime tokenCreationDate;
	@Lob
	@Column(columnDefinition = "longblob")
	@Getter @Setter private byte[] image; 

	
	/*
	 *  - A pessoa cadastra com email e senha
	- Faz login com email e senha
 	- Dai inicialmente a pessoa vai ter um apelido tipo "Estudante" + numero aleatorio
 
 	- Nas opções a pessoa troca para um apelido que não esteja sendo usado
 	
 	
	 */
}

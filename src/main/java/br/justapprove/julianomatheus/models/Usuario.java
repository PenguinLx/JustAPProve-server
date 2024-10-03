package br.justapprove.julianomatheus.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private Integer id;
	@Getter @Setter private String email;
	@Getter @Setter private String senha;
	@Getter @Setter private int ponto;
	@Getter	@Setter	private String userName;
	@Getter @Setter private byte[] image; 

	
	/*
	 *  - A pessoa cadastra com email e senha
	- Faz login com email e senha
 	- Dai inicialmente a pessoa vai ter um apelido tipo "Estudante" + numero aleatorio
 
 	- Nas opções a pessoa troca para um apelido que não esteja sendo usado
 	
 	
	 */
}

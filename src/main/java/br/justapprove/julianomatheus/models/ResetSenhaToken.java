package br.justapprove.julianomatheus.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class ResetSenhaToken {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;//Auto? Identity?
	private String token;
	
	 @OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
	    @JoinColumn(nullable = false, name = "usuarioS_id")
	    private Usuario usuario;
	 
	    private Date expiryDate;

}

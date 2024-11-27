package br.justapprove.julianomatheus.models;

import lombok.Getter;
import lombok.Setter;

public class LoginRequest {
	
	@Getter @Setter private String email;
    @Getter @Setter private String senha;
    @Getter @Setter	private String token;
	

     
   
}

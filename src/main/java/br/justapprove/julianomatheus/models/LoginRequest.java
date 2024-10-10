package br.justapprove.julianomatheus.models;

import lombok.Getter;
import lombok.Setter;

public class LoginRequest {
	
	 private String email;
     private String senha;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

     
   
}

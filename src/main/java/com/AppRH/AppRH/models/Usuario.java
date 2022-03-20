package com.AppRH.AppRH.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue
	private long id;

	@Column(unique = true)
	private String nomeUsuario;
	
	@NotEmpty
	private String Cargo;
	
	@ManyToOne
	private Recado Recado;

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getCargo() {
		return Cargo;
	}

	public void setCargo(String cargo) {
		Cargo = cargo;
	}

	public Recado getRecado() {
		return Recado;
	}

	public void setRecado(Recado recado) {
		Recado = recado;
	}
	
	
	
}

package com.AppRH.AppRH.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Recado implements Serializable {
	
	private static final long serialersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String texto;
	
	public long getCodigo() {
		return codigo;
	}
	
	public List<Usuario> getUsuarios() {
		return usuario;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuario = usuarios;
	}

	@ManyToMany(mappedBy = "Recado", cascade = CascadeType.REMOVE)
	private List<Usuario> usuario;

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public static long getSerialersionuid() {
		return serialersionUID;
	}

	

}

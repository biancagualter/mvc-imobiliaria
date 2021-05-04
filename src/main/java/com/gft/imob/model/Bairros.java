package com.gft.imob.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Bairros {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Você precisa inserir o nome de um bairro!")
	@Size(max= 30, message = "O nome do municipio deve ter até 30 caracteres!")
	private String bairro;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	@NotNull(message = "Você precisa cadastrar um município!")
	private Municipios municipio;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	@NotNull(message = "Você precisa cadastrar um estado!")
	private Estados estado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Municipios getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Municipios municipio) {
		this.municipio = municipio;
	}
	public Estados getEstado() {
		return estado;
	}
	public void setEstado(Estados estado) {
		this.estado = estado;
	}
	
	
}

package com.gft.imob.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Municipios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Você precisa inserir o nome de um município!")
	@Size(max= 30, message = "O nome do municipio deve ter até 30 caracteres!")
	private String municipio;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@NotNull(message = "Você precisa cadastrar um estado!")
	private Estados estado;
	
	@OneToMany(mappedBy="municipio", cascade = CascadeType.ALL)
	private List<Bairros> bairros;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public Estados getEstado() {
		return estado;
	}
	public void setEstado(Estados estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return municipio;
	}
	
	
	
	
}

package com.gft.imob.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Negocios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	private String negocio;
	
	@OneToMany(mappedBy="negocio", fetch = FetchType.EAGER)
    private List<Imoveis> imoveis;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNegocio() {
		return negocio;
	}

	public void setNegocio(String negocio) {
		this.negocio = negocio;
	}


	@Override
	public String toString() {
		return negocio;
	}

	
	
}

package com.gft.imob.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Estados {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Você precisa inserir uma UF!")
	@Size(max= 2, message = "Uma UF pode ter somente 2 caracteres!")
	private String uf;
	
	@NotBlank(message = "Você precisa inserir o nome de um estado!")
	@Size(max= 20, message = "O nome do estado deve ter até 20 caracteres!")
	private String estado;
	
	@OneToMany(mappedBy="estado", fetch = FetchType.EAGER)
    private List<Imoveis> imoveis;
 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return estado;
	}	
	
	
}

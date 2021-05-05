package com.gft.imob.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Você precisa inserir uma categoria!")
    @Size(max = 20, message = "Categoria deve ter até 20 caracteres!")
    private String categoria;
    
    @OneToMany(mappedBy="categoria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Imoveis> imoveis;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

	@Override
	public String toString() {
		return categoria;
	}

	public List<Imoveis> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<Imoveis> imoveis) {
		this.imoveis = imoveis;
	}
    
    

}
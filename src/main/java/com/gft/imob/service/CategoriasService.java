package com.gft.imob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.imob.model.Categorias;
import com.gft.imob.repository.CategoriasRepository;

@Service
public class CategoriasService {

	@Autowired
	private CategoriasRepository categoriasRepository;
	
	
	public void salvar(Categorias categorias) {
		categoriasRepository.save(categorias);
	}
}

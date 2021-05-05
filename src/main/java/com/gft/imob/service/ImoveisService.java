package com.gft.imob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gft.imob.model.Imoveis;
import com.gft.imob.repository.ImoveisRepository;

@Service
public class ImoveisService {
	
	@Autowired
	private ImoveisRepository imoveisRepository;
	
	public void salvar(Imoveis imoveis) {
		
		try {
			imoveisRepository.save(imoveis);
		} catch (DataIntegrityViolationException e){
			throw new IllegalArgumentException("Formato de data inválido!");
		}
	}
}

package com.gft.imob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.imob.model.Imoveis;

public interface ImoveisRepository extends JpaRepository<Imoveis, Long>{
	
}

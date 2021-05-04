package com.gft.imob.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;

import com.gft.imob.model.Estados;
import com.gft.imob.model.Municipios;
import com.gft.imob.repository.EstadosRepository;
import com.gft.imob.repository.MunicipiosRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/municipios")
@Controller
public class MunicipiosController {
	
	@Autowired
	private MunicipiosRepository municipiosRepository;
	
	@Autowired
	private EstadosRepository estadosRepository;
	
	@RequestMapping("/novo")
	public ModelAndView novoMunicipio() {
		
		List<Estados> listaEstados = estadosRepository.findAll();
		
		ModelAndView mv = new ModelAndView("municipios/MunicipiosPage");
		mv.addObject("municipios", new Municipios());
		mv.addObject("lista", listaEstados);
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Municipios municipios, Errors errors, RedirectAttributes attributes, Model model) {
		
		if (errors.hasErrors()) {
			return "municipios/MunicipiosPage";
		}
		
		List<Estados> listaEstados = estadosRepository.findAll();
		model.addAttribute("lista", listaEstados);
		
		municipiosRepository.save(municipios);
		attributes.addFlashAttribute("mensagem", "Município salvo!");
		return "redirect:/municipios/novo";
	}
	
	@RequestMapping
	public ModelAndView listar() {
		List<Municipios> allMunicipios = municipiosRepository.findAll();
		
		ModelAndView mv = new ModelAndView("municipios/MunicipiosListPage");
		mv.addObject("municipios", allMunicipios);
		return mv;
	}
	
	@RequestMapping("{id}")
	public String editar(@PathVariable("id") Long idMun, Model model) {
		Optional<Municipios> municipios = municipiosRepository.findById(idMun);
		if(municipios.isPresent()) {
			model.addAttribute("municipios", municipios.get());
		}
		
		List<Estados> listaEstados = estadosRepository.findAll();
		model.addAttribute("lista", listaEstados);

		return "municipios/MunicipiosPage";
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		municipiosRepository.deleteById(id);
		
		attributes.addFlashAttribute("mensagem", "Município excluído!");
		return "redirect:/municipios";
	}

}
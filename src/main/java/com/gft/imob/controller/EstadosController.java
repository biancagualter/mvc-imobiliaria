package com.gft.imob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;

import com.gft.imob.model.Estados;
import com.gft.imob.repository.EstadosRepository;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/estados")
@Controller
public class EstadosController {

	@Autowired
	private EstadosRepository estadosRepository;
	

	@RequestMapping("/novo")
	public ModelAndView novoEstado() {
		ModelAndView mv = new ModelAndView("estados/EstadosPage");
		mv.addObject(new Estados());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Estados estados, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return "estados/EstadosPage";
		}
		estadosRepository.save(estados);
		attributes.addFlashAttribute("mensagem", "Estado salvo!");
		return "redirect:/estados/novo";
	}

	@RequestMapping
	public ModelAndView listar() {
		List<Estados> allEstados = estadosRepository.findAll();

		ModelAndView mv = new ModelAndView("estados/EstadosListPage");
		mv.addObject("estados", allEstados);
		return mv;
	}

	@RequestMapping("{id}")
	public ModelAndView editar(@PathVariable("id") Long idEst) {
		Estados estadosList = estadosRepository.getOne(idEst);

		ModelAndView mv = new ModelAndView("estados/EstadosPage");
		mv.addObject(estadosList);
		return mv;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		estadosRepository.deleteById(id);

		attributes.addFlashAttribute("mensagem", "Estado excluído!");
		return "redirect:/estados";
	}
}
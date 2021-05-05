package com.gft.imob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;

import com.gft.imob.model.Negocios;
import com.gft.imob.repository.NegociosRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/negocios")
@Controller
public class NegociosController {
	
	@Autowired
	private NegociosRepository negociosRepository;
	
	@RequestMapping("/novo")
	public ModelAndView novoNegocio() {
		ModelAndView mv = new ModelAndView("negocios/NegociosPage");
		mv.addObject(new Negocios());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Negocios negocios, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return "negocios/NegociosPage";
		}
		
		negociosRepository.save(negocios);
		attributes.addFlashAttribute("mensagem", "Negócio salvo!");
		return "redirect:/negocios/novo";
	}
	
	@RequestMapping
	public ModelAndView listar() {
		List<Negocios> allNegocios = negociosRepository.findAll();
		
		ModelAndView mv = new ModelAndView("negocios/NegociosListPage");
		mv.addObject("negocios", allNegocios);
		return mv;
	}
	
	@RequestMapping("{id}")
	public ModelAndView editar(@PathVariable("id") Long idNeg) {
		Negocios negociosList = negociosRepository.getOne(idNeg);
		
		ModelAndView mv = new ModelAndView("negocios/NegociosPage");
		mv.addObject(negociosList);
		return mv;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		negociosRepository.deleteById(id);
		
		attributes.addFlashAttribute("mensagem", "Negócio excluído!");
		return "redirect:/negocios";
	}
}
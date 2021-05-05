package com.gft.imob.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;

import com.gft.imob.model.Categorias;
import com.gft.imob.repository.CategoriasRepository;
import com.gft.imob.service.CategoriasService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/categorias")
@Controller
public class CategoriasController {
	
	@Autowired
	private CategoriasRepository categoriasRepository;
	
	@RequestMapping("/novo")
	public ModelAndView novaCategoria() {
		ModelAndView mv = new ModelAndView("categorias/CategoriasPage");
		mv.addObject(new Categorias());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Categorias categorias, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return "categorias/CategoriasPage";
		}
		categoriasRepository.save(categorias);
		attributes.addFlashAttribute("mensagem", "Categoria salva!");
		return "redirect:/categorias/novo";
	}
	
	@RequestMapping
	public ModelAndView listar() {
		List<Categorias> allCategorias = categoriasRepository.findAll();
		
		ModelAndView mv = new ModelAndView("categorias/CategoriasListPage");
		mv.addObject("categorias", allCategorias);
		return mv;
	}
	
	@RequestMapping("{id}")
	public String editar(@PathVariable("id") Long idCat, Model model) {
		Optional<Categorias> categorias = categoriasRepository.findById(idCat);
		if(categorias.isPresent()) {
			model.addAttribute("categorias", categorias.get());
		}

		return "categorias/CategoriasPage";
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		categoriasRepository.deleteById(id);
		
		attributes.addFlashAttribute("mensagem", "Categoria excluída!");
		return "redirect:/categorias";
	}
}

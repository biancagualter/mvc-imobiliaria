package com.gft.imob.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;

import com.gft.imob.model.Categorias;
import com.gft.imob.model.Estados;
import com.gft.imob.model.Imoveis;
import com.gft.imob.model.Negocios;
import com.gft.imob.repository.CategoriasRepository;
import com.gft.imob.repository.EstadosRepository;
import com.gft.imob.repository.ImoveisRepository;
import com.gft.imob.repository.NegociosRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/imoveis")
@Controller
public class ImoveisController {
	
	@Autowired
	private ImoveisRepository imoveisRepository;
	
	@Autowired
	private NegociosRepository negociosRepository;
	
	@Autowired
	private CategoriasRepository categoriasRepository;
	
	@Autowired
	private EstadosRepository estadosRepository;
	
	
	@RequestMapping("/novo")
	public ModelAndView novoImovel() {
		
		List<Negocios> listaNegocios = negociosRepository.findAll();
		List<Categorias> listacategorias = categoriasRepository.findAll();
		List<Estados> listaEstados = estadosRepository.findAll();
		
		ModelAndView mv = new ModelAndView("imoveis/ImoveisPage");
		mv.addObject(new Imoveis());
		mv.addObject("listaNegocios", listaNegocios);
		mv.addObject("listaCategorias", listacategorias);
		mv.addObject("listaEstados", listaEstados);
		
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Imoveis imoveis, Errors errors, RedirectAttributes attributes, Model model) {
		if (errors.hasErrors()) {
			List<Negocios> listaNegocios = negociosRepository.findAll();
			List<Categorias> listacategorias = categoriasRepository.findAll();
			List<Estados> listaEstados = estadosRepository.findAll();
			
			model.addAttribute("listaNegocios", listaNegocios);
			model.addAttribute("listaCategorias", listacategorias);
			model.addAttribute("listaEstados", listaEstados);
			return "imoveis/ImoveisPage";
		}
		
		try {
			imoveisRepository.save(imoveis);
			attributes.addFlashAttribute("mensagem", "Imóvel salvo!");
			return "redirect:/imoveis/novo";
		} catch (DataIntegrityViolationException e) {
			errors.rejectValue("data", null, "Data inválida!");
			return "imoveis/ImoveisPage";
		}
		
	}
	
	@RequestMapping
	public ModelAndView listar() {
		List<Imoveis> allImoveis = imoveisRepository.findAll();

		
		ModelAndView mv = new ModelAndView("imoveis/ImoveisListPage");
		mv.addObject("imoveis", allImoveis);
		
		return mv;
	}
	
	@RequestMapping("{id}")
	public String editar(@PathVariable("id") Long idImo, Model model) {
		Optional<Imoveis> imoveis = imoveisRepository.findById(idImo);
		if(imoveis.isPresent()) {
			model.addAttribute("imoveis", imoveis.get());
		}
		
		List<Negocios> listaNegocios = negociosRepository.findAll();
		List<Categorias> listacategorias = categoriasRepository.findAll();
		List<Estados> listaEstados = estadosRepository.findAll();
		
		model.addAttribute("listaNegocios", listaNegocios);
		model.addAttribute("listaCategorias", listacategorias);
		model.addAttribute("listaEstados", listaEstados);

		return "imoveis/ImoveisPage";
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long id) {
		imoveisRepository.deleteById(id);
		
		return "redirect:/imoveis";
	}

}

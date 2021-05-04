package com.gft.imob.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import com.gft.imob.model.Bairros;
import com.gft.imob.model.Estados;
import com.gft.imob.model.Municipios;
import com.gft.imob.repository.BairrosRepository;
import com.gft.imob.repository.EstadosRepository;
import com.gft.imob.repository.MunicipiosRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/bairros")
@Controller
public class BairrosController {

	@Autowired
	private BairrosRepository bairrosRepository;
	
	@Autowired
	private EstadosRepository estadosRepository;
	
	@Autowired
	private MunicipiosRepository municipiosRepository;

	@RequestMapping("/novo")
	public ModelAndView novoBairro() {
		
		List<Estados> listaEstados = estadosRepository.findAll();
		List<Municipios> listaMunicipios = municipiosRepository.findAll();
		
		ModelAndView mv = new ModelAndView("/bairros/BairrosPage");
		mv.addObject(new Bairros());
		mv.addObject("listaEstados", listaEstados);
		mv.addObject("listaMunicipios", listaMunicipios);

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(Bairros bairros, Errors errors, RedirectAttributes attributes, Model model) {
		
		if (errors.hasErrors()) {
			return "bairros/BairrosPage";
		}
		
		List<Estados> listaEstados = estadosRepository.findAll();
		List<Municipios> listaMunicipios = municipiosRepository.findAll();
		
		model.addAttribute("listaEstados", listaEstados);
		model.addAttribute("listaMunicipios", listaMunicipios);

		attributes.addFlashAttribute("mensagem", "Bairro salvo!");
		return "redirect:/bairros/novo";
	}

	@RequestMapping
	public ModelAndView listar() {
		List<Bairros> allBairros = bairrosRepository.findAll();

		ModelAndView mv = new ModelAndView("bairros/BairrosListPage");
		mv.addObject("bairros", allBairros);
		return mv;
	}

	@RequestMapping("{id}")
	public String editar(@PathVariable("id") Long idBai, Model model) {
		Optional<Bairros> bairros = bairrosRepository.findById(idBai);
		if(bairros.isPresent()) {
			model.addAttribute("bairros", bairros.get());
		}
		
		List<Estados> listaEstados = estadosRepository.findAll();
		List<Municipios> listaMunicipios = municipiosRepository.findAll();
		
		model.addAttribute("listaEstados", listaEstados);
		model.addAttribute("listaMunicipios", listaMunicipios);

		return "bairros/BairrosPage";
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long id) {
		bairrosRepository.deleteById(id);

		return "redirect:/bairros";
	}
}
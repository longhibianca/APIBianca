package com.example.APIBianca.controllerView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.APIBianca.model.Escola;
import com.example.APIBianca.repository.EscolaRepo;

@Controller
@RequestMapping("/escolas")
public class EscolasController {
	
	@Autowired
	EscolaRepo escolas;



	@RequestMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaEscolas");
		mv.addObject(new Escola());	
		mv.addObject("escolas",escolas.findAll());
		return mv;
	}

	@RequestMapping(value="",method=RequestMethod.POST)
	public String gravar(Escola e) {
		escolas.save(e);
		return "redirect:/escolas";
	}

	@RequestMapping(value="alterar/{id}")
	public ModelAndView atualizaEscola(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("ListaEscolas");
		Escola escola = escolas.getOne(id);
		mv.addObject(escola);
		mv.addObject("escolas",escolas.findAll());
		return mv;
	}

	@RequestMapping(value="/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		escolas.deleteById(id);
		return "redirect:/escolas";
	}

}

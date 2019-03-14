package com.example.APIBianca.controllerView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.APIBianca.model.Estudante;
import com.example.APIBianca.repository.EscolaRepo;
import com.example.APIBianca.repository.EstudanteRepo;

@Controller
@RequestMapping("/estudantes")
public class EstudantesController {
	@Autowired
	EstudanteRepo estudantes;

	@Autowired 
	EscolaRepo escolas;

	@RequestMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaEstudantes");
		mv.addObject(new Estudante());	
		mv.addObject("estudantes",estudantes.findAll());
		mv.addObject("escolas",escolas.findAll());
		return mv;
	}

	@RequestMapping(value="",method=RequestMethod.POST)
	public String gravar(Estudante e) {
		estudantes.save(e);
		return "redirect:/estudantes";
	}

	@RequestMapping(value="alterar/{id}")
	public ModelAndView atualizaEscola(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("ListaEstudantes");
		Estudante estudante = estudantes.getOne(id);
		mv.addObject(estudante);
		mv.addObject("escolas",estudantes.findAll());
		mv.addObject("escolas",escolas.findAll());
		return mv;
	}

	@RequestMapping(value="/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		estudantes.deleteById(id);
		return "redirect:/estudantes";
	}

}

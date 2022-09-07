package com.study.point.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.point.entities.Classe;
import com.study.point.repositories.ClasseRepository;

@Controller
@RequestMapping("/classes/")
public class ClasseController {

	private final ClasseRepository classeRepository;

	@Autowired
	public ClasseController(ClasseRepository classeRepository) {
		this.classeRepository = classeRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Classe Classe) {
		return "add-Classe";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("classes", classeRepository.findAll());
		return "classes";
	}

	@PostMapping("add")
	public String addClasse(@Valid Classe Classe, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-Classe";
		}

		classeRepository.save(Classe);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Classe Classe = classeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Classe Id:" + id));
		model.addAttribute("classe", Classe);
		return "update-Classe";
	}

	@PostMapping("update/{id}")
	public String updateClasse(@PathVariable("id") long id, @Valid Classe classe, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			//Classe.setId(id);
			return "update-Classe";
		}

		classeRepository.save(classe);
		model.addAttribute("classes", classeRepository.findAll());
		return "classes";
	}

	@GetMapping("delete/{id}")
	public String deleteClasse(@PathVariable("id") long id, Model model) {
		Classe Classe = classeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Classe Id:" + id));
		classeRepository.delete(Classe);
		model.addAttribute("classes", classeRepository.findAll());
		return "classes";
	}
}

package com.uisrael.ComputadorasS2.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uisrael.ComputadorasS2.modelo.Computadoras;
import com.uisrael.ComputadorasS2.repository.Computadora_Repository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class ComputadorasController {
	@Autowired
	private Computadora_Repository computadoraRepository;
	
	@GetMapping
	public String home() {
		return "redirect:/computadora";
	}
	@GetMapping("/computadora")
	public String listarComputadora(Model model) {
		List<Computadoras> computadoras = computadoraRepository.findAll();
		computadoras = computadoraRepository.findAll();
		model.addAttribute("computadora",computadoras);
		return "computadora";
	}
	
	//Controlador para nuevo computador
	@GetMapping("/computadora/nuevo")
	public String agregarComputadora(Model model) {
		Computadoras computadoras = new Computadoras();
		model.addAttribute("computadora",computadoras);
		model.addAttribute("pageTitle","Nueva computadora");
		return "computadora_form";
	}
	@PostMapping("/computadora/save")
	public String guardarComputadora(Computadoras computadoras,RedirectAttributes redirectAttributes) {
		try {
			computadoraRepository.save(computadoras);
			redirectAttributes.addFlashAttribute("message","El computador ha sido guardo con exito");
		} catch (Exception e) {
			redirectAttributes.addAttribute("message",e.getMessage());
		}
		
		return "redirect:/computadora";
	}
	
	
	

}

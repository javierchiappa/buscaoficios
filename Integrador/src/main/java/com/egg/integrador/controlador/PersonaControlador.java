package com.egg.integrador.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.egg.integrador.Persona;

import com.egg.integrador.repositorios.PersonaRepository;

@Controller
@RequestMapping("/persona")
public class PersonaControlador {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@GetMapping("/inicio")
	public ModelAndView inicio(@RequestParam(required=false) Integer persona_id) {
		
		Persona persona = new Persona();
		if(persona_id != null) {
			persona = personaRepository.findById(persona_id).get();
		}
		
		ModelAndView modelo = new ModelAndView();
		modelo.setViewName("persona-formulario.html");
		modelo.addObject("persona", persona);
		return modelo;
	}
	
	
	@PostMapping("/guardar")
	public ModelAndView guardar(@ModelAttribute("persona") Persona persona) {
		System.out.println("Cancha: " + persona.toString());

		personaRepository.save(persona);
		
		ModelAndView modelo = new ModelAndView();
		modelo.setViewName("persona-formulario.html");
		modelo.addObject("persona", persona);
		modelo.addObject("mensaje", "La persona se guardo correctamente.");
		
		
		return modelo;
	}
	
	
	@GetMapping("/listado")
	public ModelAndView listado() {
		ModelAndView modelo = new ModelAndView();
		
		List<Persona> persona = personaRepository.findAll();
		
		modelo.addObject("persona", persona);
		modelo.setViewName("persona-listado");
		
		return modelo;
	}
	
	

	@GetMapping("/eliminar")
	public String eliminar(@RequestParam Integer persona_id) {
		
		if(persona_id != null) {
			Persona persona = personaRepository.findById(persona_id).get();
			personaRepository.delete(persona);
		}
		
		return "redirect:/persona/listado";
	}
}

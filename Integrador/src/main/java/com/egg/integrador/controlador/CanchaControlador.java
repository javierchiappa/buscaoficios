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

import com.egg.integrador.Cancha;
import com.egg.integrador.repositorios.CanchaRepository;

@Controller
@RequestMapping("/cancha")
public class CanchaControlador {
	
	@Autowired
	private CanchaRepository canchaRepository;
	
	@GetMapping("/inicio")
	public ModelAndView inicio(@RequestParam(required=false) Integer idCancha) {
		
		Cancha cancha = new Cancha();
		if(idCancha != null) {
			cancha = canchaRepository.findById(idCancha).get();
		}
		
		ModelAndView modelo = new ModelAndView();
		modelo.setViewName("cancha-formulario.html");
		modelo.addObject("cancha", cancha);
		return modelo;
	}
	
	
	@PostMapping("/guardar")
	public ModelAndView guardar(@ModelAttribute Cancha cancha) {
		System.out.println("Cancha: " + cancha.toString());
                ModelAndView modelo = new ModelAndView();    
		
		
		if (cancha.getNombre() != null && cancha.getNombre().isEmpty()){
                     modelo.addObject("error", "El nombre de la cancha es nulo");
                } else {
                    canchaRepository.save(cancha);
                    modelo.addObject("mensaje", "La cancha se guardo correctamente");
                }
		modelo.setViewName("cancha-formulario.html");
		modelo.addObject("cancha", cancha);

		
		return modelo;
	}
	
	
	@GetMapping("/listado")
	public ModelAndView listado() {
		ModelAndView modelo = new ModelAndView();
		
		List<Cancha> canchas = canchaRepository.findAll();
		
		modelo.addObject("canchas", canchas);
		modelo.setViewName("cancha-listado");
		
		return modelo;
	}
	
	

	@GetMapping("/eliminar")
	public String eliminar(@RequestParam Integer idCancha) {
		
		if(idCancha != null) {
			Cancha cancha = canchaRepository.findById(idCancha).get();
			canchaRepository.delete(cancha);
		}
		
		return "redirect:/cancha/listado";
	}
}

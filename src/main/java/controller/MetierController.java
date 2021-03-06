package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.Metier;
import repository.MetierRepository;
import repository.ServiceRepository;



@Controller
@RequestMapping("/metier")
public class MetierController {

	
	
	@Autowired
	MetierRepository metierRepository;
	
	@Autowired
	ServiceRepository serviceRepository;
	
	@GetMapping("/listmetier")
	public ModelAndView list() {
		return new ModelAndView("metier/listmetier", "metiers", metierRepository.findAll());
	}
	
	
	@GetMapping("/delete")
	public  ModelAndView delete(@RequestParam (name="idMetier") long idMetier) {
		metierRepository.deleteById(idMetier);
		return new ModelAndView("redirect:/metier/listmetier");
	}
	
	@GetMapping("/addmetier")
	public ModelAndView addmetier() {
		return new ModelAndView("metier/addmetier", "metier", new Metier());
		
	}
	@PostMapping("/savemetier")
	public ModelAndView save(@ModelAttribute("metier") Metier metier){
		metierRepository.save(metier);
		return new ModelAndView("redirect:/metier/listmetier");
	}
	

	}


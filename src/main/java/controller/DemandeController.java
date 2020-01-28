package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import repository.DemandeRepository;

@Controller
@RequestMapping("/demande")
public class DemandeController {

	@Autowired
	DemandeRepository demandeRepository;
	
	@GetMapping
	public ModelAndView list() {
		return new ModelAndView("demande/listdemande", "demandes", demandeRepository);
	}
	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name=""))
}

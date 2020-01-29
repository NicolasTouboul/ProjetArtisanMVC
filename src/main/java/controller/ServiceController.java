package controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.Civilite;
import model.Personne;
import model.Salle;
import repositories.SalleRepository;

@Controller
@RequestMapping("/salle")
public class ServiceController {

	
	
	@Autowired
	SalleRepository salleRepository;
	
	@GetMapping("/listsalle")
	public ModelAndView list() {
		return new ModelAndView("salle/listsalle", "salles", salleRepository.findAll());
	}
	
//	@GetMapping("/listsalle")
//	public String listsalle(Model model) {
//		model.addAttribute("salles",salleRepository.findAll());
//
//		return "salle/listsalle";
//	}
	
//	@GetMapping("/editsalle")
//	public String edit(@RequestParam(name="nom") String nom,Model model) {
//		Optional<Salle> opt= salleRepository.findById(nom);
//		Salle s=null;
//		if(opt.isPresent()) {
//			s=opt.get();
//		}
//		return goEdit(s, model);
//	}
//	
	@GetMapping("/delete")
	public  ModelAndView delete(@RequestParam (name="nom") String nom) {
		salleRepository.deleteById(nom);
		return new ModelAndView("redirect:/salle/listsalle");
	}
	
	@GetMapping("/addsalle")
	public ModelAndView addSalle() {
		return new ModelAndView("salle/addsalle", "salle", new Salle());
		
	}
	@PostMapping("/savesalle")
	public ModelAndView save(@ModelAttribute("salle") Salle salle){
		salleRepository.save(salle);
		return new ModelAndView("redirect:/salle/listsalle");
	}
	
//	@GetMapping("/addsalle")
//	public String addsalle(@ModelAttribute Salle s, Model model) {
//		return goEdit(new Salle(), model);
//		
//	}
//	
//	@GetMapping("/delete")
//	public String delete(@RequestParam (name="nom") String nom) {
//		salleRepository.deleteById(nom);
//		return "redirect:/salle/listsalle";
//	}
//	
//	@PostMapping("/savesalle")
//	public String saveSalle(@ModelAttribute Salle salle, Model model) {
//		return save(salle, model);
//	}
//	
//	
//	
//	public String save( Salle salle, Model model) {
//		salleRepository.save(salle);
//		return "redirect:/salle/listsalle";
//	}
//	
//	private String goEdit(Salle s, Model model) {
//		
//		model.addAttribute("salle", s);
//
//		return "salle/addsalle";
//}
	}


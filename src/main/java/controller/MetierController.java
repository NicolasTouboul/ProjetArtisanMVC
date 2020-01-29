package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import repository.MetierRepository;



@Controller
@RequestMapping("/salle")
public class MetierController {

	
	
	@Autowired
	MetierRepository MetierRepository;
	
	@GetMapping("/listsalle")
	public ModelAndView list() {
		return new ModelAndView("salle/listsalle", "salles", MetierRepository.findAll());
	}
	
//	@GetMapping("/listsalle")
//	public String listsalle(Model model) {
//		model.addAttribute("salles",MetierRepository.findAll());
//
//		return "salle/listsalle";
//	}
	
//	@GetMapping("/editsalle")
//	public String edit(@RequestParam(name="nom") String nom,Model model) {
//		Optional<Salle> opt= MetierRepository.findById(nom);
//		Salle s=null;
//		if(opt.isPresent()) {
//			s=opt.get();
//		}
//		return goEdit(s, model);
//	}
//	
	@GetMapping("/delete")
	public  ModelAndView delete(@RequestParam (name="nom") String nom) {
		MetierRepository.deleteById(nom);
		return new ModelAndView("redirect:/salle/listsalle");
	}
	
	@GetMapping("/addsalle")
	public ModelAndView addSalle() {
		return new ModelAndView("metier/addMetier", "metier", new Metier());
		
	}
	@PostMapping("/savesalle")
	public ModelAndView save(@ModelAttribute("metier") Metier metier){
		MetierRepository.save(metier);
		return new ModelAndView("redirect:/metier/listmetier");
	}
	
//	@GetMapping("/addsalle")
//	public String addsalle(@ModelAttribute Salle s, Model model) {
//		return goEdit(new Salle(), model);
//		
//	}
//	
//	@GetMapping("/delete")
//	public String delete(@RequestParam (name="nom") String nom) {
//		MetierRepository.deleteById(nom);
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
//		MetierRepository.save(salle);
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


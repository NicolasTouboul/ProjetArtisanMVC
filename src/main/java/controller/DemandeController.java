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

import model.Demande;
import repository.DemandeRepository;

@Controller
@RequestMapping("/demande")
public class DemandeController {

	@Autowired
	DemandeRepository demandeRepository;
	
	@GetMapping("/listdemande")
	public ModelAndView list() {
		return new ModelAndView("demande/listdemande", "demandes", demandeRepository);
	}
	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name="idDemande")Long idDemande) {
		demandeRepository.deleteById(idDemande);
		return new ModelAndView("redirect:/demande/listdemande");
	}
	@PostMapping("/savedemande")
	public ModelAndView save(@ModelAttribute("demande") Demande demande) {
	demandeRepository.save(demande);
	return new ModelAndView("redirect:/demande/listdemande");
}
	@GetMapping("/addDemande")
	public ModelAndView adddemande() {
		return new ModelAndView("demande/addDemande", "demande", new Demande());
	}
	
	@GetMapping("/editdemande")
	public String edit(@RequestParam(name="idDemande") Long idDemande, Model model) {
	Optional<Demande> opt=demandeRepository.findById(idDemande);
	Demande d=null;
	if (opt.isPresent()) {
		d=opt.get();
	}
	return goEdit(d, model);
	}
	
	private String goEdit(Demande d, Model model) {
		
		model.addAttribute("demande", d);

		return "demande/addDemande";
}
	}


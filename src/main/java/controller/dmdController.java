package controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import model.Demande;
import model.StatutDemande;
import repository.DemandeRepository;

@Controller
@RequestMapping("/demande")
public class dmdController {
	
	@Autowired
	private DemandeRepository demandeRepository;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("demande", demandeRepository.findAll());
		return "demande/list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam(name="idDemande") Long idDemande, Model model) {
		Optional<Demande> opt=demandeRepository.findById(idDemande);
		Demande d=null;
		if(opt.isPresent()) {
			d=opt.get();
		}
		model.addAttribute("demande", d);
		return goEdit(d, model);
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		
		return goEdit(new Demande(),model);
		
	}
	
	public String goEdit(Demande d, Model model) {
		model.addAttribute("demande", d);
		model.addAttribute("statuts", StatutDemande.values());
		return "demande/edit";
	}
	
	@PostMapping("/saveDemande")
	public String saveDemande(@ModelAttribute("demande") @Valid Demande demande, BindingResult br, Model model) {
		
		return save(demande,br,model);
		
	}
	
	private String save(Demande demande, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return "demande/edit";
		}
		if(demande.getService()!=null && demande.getService().getNomService().isEmpty()) {
			demande.setService(null);;
		}
		demandeRepository.save(demande);
		return "redirect:/demande/list";
	}
	
	@GetMapping("/deleted")
	public String deleted(@RequestParam(name="idDemande") Long idDemande) {
		demandeRepository.deleteById(idDemande);
		return "redirect:/demande/list";
	}

}

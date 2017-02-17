package fr.univbrest.dosi.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.business.FormationBusiness;
import fr.univbrest.dosi.business.FormationBusinessJPA;

@RestController
@RequestMapping("formation")
public class FormationController {

	
	private  FormationBusiness formationBusiness;

	@Autowired
	public FormationController(FormationBusiness formationBusiness) {
		this.formationBusiness = formationBusiness;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Formation> listerToutesLesFormations() {
		return formationBusiness.listeDesFormations();
	}

	@RequestMapping(value = "/{codeFormation}", method = RequestMethod.GET)
	public Formation getFormationParCode(@PathVariable String codeFormation) {
		
		return formationBusiness.getFormationParCodeFormation(codeFormation);
		

	}
	
	@RequestMapping(value = "/{codeFormation}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable String codeFormation) {
		return formationBusiness.supprimerFormation(codeFormation);
		

	}
	

	
	@RequestMapping( method = RequestMethod.POST)
	public void ajouterFormation(@RequestBody Formation formation){
		 this.formationBusiness.creerFormation(formation);
		
	}

	@RequestMapping( value = "/", method = RequestMethod.PUT)
	public void modiferFormation(@RequestBody Formation formation){
		this.formationBusiness.modifierFormation(formation);
		
	}
	
	@RequestMapping( value = "/count")
	public Long count(){
		return this.formationBusiness.count();
		
	}
}


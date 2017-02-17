package fr.univbrest.dosi.business;


import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;
@Component
public class FormationBusinessJPA implements FormationBusiness{
	
	//On peut ajouter le @Autowired sur l'attribut mais il va causer des problèmes dans le test
	// Il vaut mieux l'utiliser sur le consctructeur pour dire que si vous voulez utiliser mon usiness il vous faut
	// un repository
	// sinon on peut utiliser le @Autowired sur le setter
	private FormationRepository formationRepository;
	
	@Autowired
	FormationBusinessJPA (FormationRepository formationRepository){
		this.formationRepository =formationRepository;
	}
	
	@Override
	public boolean creerFormation(Formation formation) {
		
		formationRepository.save(formation);
		return true;
}
	
	@Override
	public boolean supprimerFormation(String codeFormation) {
		Formation formationASupprimer = formationRepository.findOne(codeFormation);
		
		formationRepository.delete(codeFormation);
		return true;
	}

	@Override
	public List<Formation> listeDesFormations() {
		return Lists.newArrayList(formationRepository.findAll());
	}

	@Override
	public Formation getFormationParCodeFormation(String codeFormation) {
		Formation formationRecherchee = formationRepository
				.findOne(codeFormation);
		
		return formationRecherchee;
	}

	@Override
	public Formation getFormationParNomFormation(String nomFormation) {
		Formation formationRecherchee =  formationRepository.findByNomFormation(nomFormation);
		
		return formationRecherchee;
    }
	
	public boolean modifierFormation(Formation formation) {
		formationRepository.save(formation);
		return true;
    }
	
	public Long count() {
		return formationRepository.count();
		
    }
}

package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Formation;

public interface FormationBusiness {

	public boolean creerFormation(Formation formation);
	
	public abstract boolean supprimerFormation(String codeFormation);

	public abstract List<Formation> listeDesFormations();

	public abstract Formation getFormationParCodeFormation(String codeFormation);

    public abstract Formation getFormationParNomFormation(String nomFormation);
}

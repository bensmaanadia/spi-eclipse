package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class FormationBusinessJPATest {

	private FormationBusiness formationBusiness;
	
	@Before
	public void init() {
		FormationRepositoryStub entrepot = new FormationRepositoryStub();
    	formationBusiness = new FormationBusinessJPA(entrepot);
    	}
	
    @Test
    public void createFormation() {
    
    	Formation formation = new Formation();
		formation.setCodeFormation("AB");
		formation.setDiplome("L");
		formation.setN0Annee(new BigDecimal(1));
		formation.setNomFormation("Formation par alternance");
		formation.setDoubleDiplome("O");
		formation.setDebutAccreditation(new Date());
		formation.setFinAccreditation(new Date());
		assertThat(formationBusiness.creerFormation(formation)).isEqualTo(true);
    }
}
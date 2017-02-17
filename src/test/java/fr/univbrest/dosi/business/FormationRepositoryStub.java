package fr.univbrest.dosi.business;


import java.util.ArrayList;
import java.util.List;






import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;

//Permet de simuler une base de donnes
public class FormationRepositoryStub implements FormationRepository {

	List<Formation> formations;

	public FormationRepositoryStub() {
		formations = new ArrayList<Formation>();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void delete(Formation entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Formation> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}



	@Override
	public Iterable<Formation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	

	@Override
	public <S extends Formation> S save(S entity) {
		formations.add(entity);
		return null;
	}

	@Override
	public <S extends Formation> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Formation> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Formation findOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Formation findByNomFormation(String nomFormation) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

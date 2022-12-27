package terain.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import terain.entities.Ville;

@Stateless
public class LocalImpl<T> implements Local<T>{
	@PersistenceContext    //(unitName = "") si on a plusieur unite de persistance 01:00:00 
	private EntityManager em;

	@Override
	public T add(T obj) {
		em.persist(obj);
		return obj;
	}

	@Override
	public List<T> Liste() {
		Query req=em.createQuery("from Terain");
		return req.getResultList();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		em.remove(em.find(Ville.class,id ));
	}

	@Override
	public T find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(T obj) {
		// TODO Auto-generated method stub
		
	}
}

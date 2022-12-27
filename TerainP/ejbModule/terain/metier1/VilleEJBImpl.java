package terain.metier1;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import terain.entities.Ville;

@Stateless(name = "Ville")
public class VilleEJBImpl implements LocalVille{
	@PersistenceContext    //(unitName = "") si on a plusieur unite de persistance 01:00:00 
	private EntityManager em;
	@Override
	public Ville addVille(Ville ville) {
		em.persist(ville);
		return ville;
	}

	@Override
	public List<Ville> villeListe() {
		Query req=em.createQuery("select v from Ville v");
		return req.getResultList();
	}

	@Override
	public void deleteVille(int id) {
		// TODO Auto-generated method stub
		em.remove(em.find(Ville.class,id ));
	}

	@Override
	public Ville findVille(int id) {	
		return em.find(Ville.class, id);
	}

	@Override
	public void UpdateVille(Ville ville) {
		Ville v=findVille(ville.getId());
		v.setNom(ville.getNom());
		em.persist(v);
	}

}

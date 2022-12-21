package terain.metier;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import terain.entities.Ville;
import terain.entities.Zone;

@Stateless(name = "Tr")  //utiliser ce nom lors de cree une reference dans l'annulaire (@ip/port...) 
public class TerainEJBImpl implements TerainLocal, TerainRemote {
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

	@Override
	public Zone addZone(String name,Ville ville) {
		
		em.persist(new Zone(name,em.getReference(Ville.class, ville.getId())));
		return null;
	}

	@Override
	public List<Zone> zoneListe() {
	
		Query req=em.createQuery("from Zone");
		return req.getResultList();
	}

	@Override
	public void deleteZone(int id) {
		// TODO Auto-generated method stub
		em.remove(em.find(Zone.class,id));
	}

	@Override
	public Zone findZone(int id) {
		// TODO Auto-generated method stub
		
		return em.find(Zone.class, id);
	}

	@Override
	public void UpdateZone(Zone zone) {
		// TODO Auto-generated method stub
		Zone z=findZone(zone.getId());
		z.setNom(zone.getNom());
		z.setVille(zone.getVille());
		em.persist(z);
	}	
	
	

}

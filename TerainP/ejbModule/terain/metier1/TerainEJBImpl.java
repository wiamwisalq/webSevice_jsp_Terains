package terain.metier1;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import terain.entities.Club;
import terain.entities.Terain;
import terain.entities.Zone;

@Stateless(name = "Train") 
public class TerainEJBImpl implements LocalTerain{
	@PersistenceContext   
	private EntityManager em;
	@Override
	public Terain addTerain(String nom,String type,Zone zone,Club club,double longitude,double latitude,int capacite) {
		// TODO Auto-generated method stub
		Terain t=new Terain(latitude,longitude,nom,capacite,type,em.getReference(Zone.class, zone.getId()),em.getReference(Club.class, club.getId()));
		em.persist(t);
		return t;
	}

	@Override
	public List<Terain> terainListe() {
		// TODO Auto-generated method stub
		Query req=em.createQuery("from Terain");
		return req.getResultList();
	}

	@Override
	public void deleteTerain(int id) {
		em.remove(em.find(Terain.class, id));		
	}

	@Override
	public Terain findTerain(int id) {
		return em.find(Terain.class, id);
	}

	@Override
	public void UpdateTerain(int id,String nom,String type,Zone zone,Club club,double longitude,double latitude,int capacite) {
		// TODO Auto-generated method stub
		Terain t=em.find(Terain.class, id);
		t.setLatitude(latitude);
		t.setLongitude(longitude);
		t.setCapacite(capacite);
		t.setNom(nom);
		t.setType(type);
		t.setZone(em.getReference(Zone.class, zone.getId()));
		t.setClub(em.getReference(Club.class, club.getId()));
		em.persist(t);
	}
}

package terain.metier1;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import terain.entities.Club;
import terain.entities.Pack;

@Stateless(name = "Club") 
public class ClubEJBImpl implements LocalClub{
	@PersistenceContext   
	private EntityManager em;
	@Override
	public Club addClub(String nom, String type, Pack pack) {
		Club c= new Club(nom,type,em.getReference(Pack.class, pack.getId()));
		em.persist(c);
		return c;
	}

	@Override
	public List<Club> clubListe() {
		Query req=em.createQuery("from Club");
		return req.getResultList();
	}

	@Override
	public void deleteClub(int id) {
		// TODO Auto-generated method stub
		em.remove(em.find(Club.class, id));
	}

	@Override
	public Club findClub(int id) {
		// TODO Auto-generated method stub
		return em.find(Club.class, id);
	}

	@Override
	public void UpdateClub(int id, String nom, String type, Pack pack) {
		// TODO Auto-generated method stub
		Club c= em.find(Club.class, id);
		c.setNom(nom);
		c.setType(type);
		c.setPack(em.getReference(Pack.class, pack.getId()));
	}
}

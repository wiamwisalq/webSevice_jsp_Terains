package terain.metier1;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import terain.entities.Abonment;
import terain.entities.Client;
import terain.entities.Pack;

@Stateless(name = "Abonment")
public class AbonmentEJBImpl implements LocalAbonment{
	@PersistenceContext   
	private EntityManager em;
	@Override
	public Abonment addAbonment(String descri, int duree, Date date, Pack pack, Client client) {
		Abonment a=new Abonment(descri,duree,date,em.getReference(Pack.class, pack.getId()),em.getReference(Client.class, client.getId()));
		em.persist(a);
		return a;
	}

	@Override
	public List<Abonment> abonmentListe() {
		Query req=em.createQuery("from Abonment");
		return req.getResultList();
	}

	@Override
	public void deleteAbonment(int id) {
		// TODO Auto-generated method stub
		em.remove(em.find(Abonment.class, id));
	}

	@Override
	public Abonment findAbonment(int id) {
		// TODO Auto-generated method stub
		return em.find(Abonment.class, id);
	}

	@Override
	public void UpdateAbonment(int id, String descri, int duree, Date date, Pack pack, Client client) {
		// TODO Auto-generated method stub
		Abonment a=em.find(Abonment.class, id);
		a.setDesc(descri);
		a.setDuree(duree);
		a.setClient(em.getReference(Client.class, client.getId()));
		a.setPack(em.getReference(Pack.class, pack.getId()));
		a.setDate(date);
		em.persist(a);
	}

}

package terain.metier1;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import terain.entities.Club;
import terain.entities.Pack;
import terain.entities.Terain;

@Stateless(name = "Pack") 
public class PackEJBImpl implements LocalPack{
	@PersistenceContext   
	private EntityManager em;
	
	@Override
	public Pack addPack(Pack pack) {
		em.persist(pack);
		return pack;
	}

	@Override
	public List<Pack> packListe() {
		Query req=em.createQuery("from Pack");
		return req.getResultList();
	}

	@Override
	public void deletePack(int id) {
		em.remove(em.find(Pack.class, id));
	}

	@Override
	public Pack findPack(int id) {
		return em.find(Pack.class, id);
	}

	@Override
	public void UpdatePack(Pack pack) {
		Pack p=em.find(Pack.class, pack.getId());
		p.setDesc(pack.getDesc());
		p.setPrix(pack.getPrix());
		p.setNbr(pack.getNbr());
		em.persist(p);
	}
	@Override
	public boolean isExistClubs(int id) {
		Query req=em.createQuery("from Club");
		List<Club> clubs=req.getResultList();
		for (Club club : clubs) {
			if(club.getPack().getId()==id) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void deleteAllClubs(int id) {
		// TODO Auto-generated method stub
		
		Query req=em.createQuery("from Club c where c.pack.id="+id);
		List<Club> clubs =  req.getResultList();
		for (Club club : clubs) {
			Query req1=em.createQuery("from Terain t where t.club.id="+club.getId());
			List<Terain> terains =  req1.getResultList();
			for (Terain terain : terains) {
				em.remove(terain);
			}
			em.remove(club);
		}
		deletePack(id);
	}

}

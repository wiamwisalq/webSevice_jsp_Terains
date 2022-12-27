package terain.metier1;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import terain.entities.Club;
import terain.entities.Terain;
import terain.entities.Ville;
import terain.entities.Zone;

@Stateless(name = "Zone")
public class ZoneEJBImpl implements LocalZone{
	@PersistenceContext   
	private EntityManager em;
	
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
	public void UpdateZone(Zone zone,Ville v,String nom) {
		// TODO Auto-generated method stub
		Zone z=findZone(zone.getId());
		z.setNom(nom);
		z.setVille(em.getReference(Ville.class, v.getId()));
		em.persist(z);
	}

	@Override
	public boolean isExistZones(int id) {
		Query req=em.createQuery("from Zone");
		List<Zone> zones=req.getResultList();
		for (Zone zone : zones) {
			if(zone.getVille().getId()==id) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void deleteAllZones(int id) {
		// TODO Auto-generated method stub
		Query req=em.createQuery("from Zone z where z.ville.id="+id);
		List<Zone> zones =  req.getResultList();
		for (Zone zone : zones) {
			em.remove(zone);
		}
		em.remove(em.find(Ville.class, id));
	}

	@Override
	public boolean isExistTerains(int id) {
		Query req=em.createQuery("from Terain");
		List<Terain> terains=req.getResultList();
		for (Terain terain : terains) {
			if(terain.getZone().getId()==id) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void deleteAllTerains(int id) {
		// TODO Auto-generated method stub
		Query req=em.createQuery("from Terain t where t.zone.id="+id);
		List<Terain> terains =  req.getResultList();
		for (Terain terain : terains) {
			em.remove(terain);
		}
		deleteZone(id);
	}

	@Override
	public boolean isExistTerainsP(int id) {
		Query req=em.createQuery("from Terain");
		List<Terain> terains=req.getResultList();
		for (Terain terain : terains) {
			if(terain.getClub().getId()==id) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void deleteAllTerainsP(int id) {
		// TODO Auto-generated method stub
		Query req=em.createQuery("from Terain t where t.club.id="+id);
		List<Terain> terains =  req.getResultList();
		for (Terain terain : terains) {
			em.remove(terain);
		}

		em.remove(em.find(Club.class,id));
	}
}

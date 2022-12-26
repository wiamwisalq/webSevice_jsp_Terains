package terain.metier;

import java.util.Date;
import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import terain.entities.Abonment;
import terain.entities.Client;
import terain.entities.Club;
import terain.entities.Pack;
import terain.entities.Reservation;
import terain.entities.ReservationPK;
import terain.entities.Terain;
import terain.entities.Ville;
import terain.entities.Zone;

@Stateless(name = "Tr")  //utiliser ce nom lors de cree une reference dans l'annulaire (@ip/port...) 
public class TerainEJBImpl implements TerainLocal, TerainRemote{
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
		deleteVille(id);
	}

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
		deleteClub(id);
	}

	@Override
	public Client addClient(Client client) {
		em.persist(new Client(client.getNom(),client.getType()));
		return client;
	}

	@Override
	public List<Client> clientListe() {
		Query req=em.createQuery("from Client");
		return req.getResultList();
	}

	@Override
	public void deleteClient(int id) {
		// TODO Auto-generated method stub
		em.remove(em.find(Client.class, id));
	}

	@Override
	public Client findClient(int id) {
		// TODO Auto-generated method stub	
		return em.find(Client.class,id);
	}

	@Override
	public void UpdateClient(Client client) {
		// TODO Auto-generated method stub
		Client c= em.find(Client.class, client.getId());
		c.setNom(client.getNom());
		c.setType(client.getType());
		em.persist(c);
	}

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

	@Override
	public Reservation addReservation(int duree,Date date, Client client,Terain terain) {
		// TODO Auto-generated method stub
		ReservationPK pk=new ReservationPK(client.getId(),terain.getId(),date);
		Reservation reservation=new Reservation(pk,duree);
		em.persist(reservation);
		return null;
	}

	@Override
	public List<Reservation> reservationListe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteReservation(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ville findReservation(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void UpdateReservation(ReservationPK pk,int duree,Date date, Client client,Terain terain) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}

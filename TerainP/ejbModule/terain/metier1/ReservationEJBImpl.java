package terain.metier1;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import terain.entities.Client;
import terain.entities.Pack;
import terain.entities.Reser;
import terain.entities.Reservation;
import terain.entities.ReservationPK;
import terain.entities.Terain;
import terain.entities.Ville;

@Stateless(name = "Reservation")
public class ReservationEJBImpl implements LocalReservation{
	@PersistenceContext   
	private EntityManager em;
	
	@Override
	public Reser addReservation(int duree,Date date, Client client,Terain terain) {
		// TODO Auto-generated method stub
		ReservationPK pk=new ReservationPK(client.getId(),terain.getId(),date);
		Reservation reservation=new Reservation(pk,duree);
		em.persist(reservation);
		Reser r= new Reser(date,duree,em.getReference(Client.class, client.getId()),em.getReference(Terain.class, terain.getId()));
		return r;
	}

	@Override
	public List<Reser> reservationListe() {
		Query req=em.createQuery("from Reser");
		return req.getResultList();
	}

	@Override
	public void deleteReservation(int id) {
		em.remove(em.find(Reser.class, id));
	}

	@Override
	public Reser findReservation(int id) {
		return em.find(Reser.class,id);
	}

	@Override
	public void UpdateReservation(int id,int duree,Date date, Client client,Terain terain) {
		// TODO Auto-generated method stub
		Reser r= em.find(Reser.class, id);
		r.setDate_res(date);
		r.setDuree(duree);
		r.setClient(em.getReference(Client.class, client.getId()));
		r.setTerain(em.getReference(Terain.class, terain.getId()));
		em.persist(r);
	}

}

package terain.metier1;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import terain.entities.Client;
import terain.entities.Reser;
import terain.entities.Reservation;
import terain.entities.ReservationPK;
import terain.entities.Terain;
import terain.entities.Ville;

@Local
public interface LocalReservation {
	public Reser addReservation(int duree,Date date, Client client,Terain terain);
	public List<Reser> reservationListe();
	public void deleteReservation(int id);
	public Reser findReservation(int id);
	public void UpdateReservation(int id,int duree,Date date, Client client,Terain terain);
}

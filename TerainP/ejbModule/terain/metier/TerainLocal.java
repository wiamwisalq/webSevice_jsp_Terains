package terain.metier;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import terain.entities.Abonment;
import terain.entities.Client;
import terain.entities.Club;
import terain.entities.Pack;
import terain.entities.Reservation;
import terain.entities.ReservationPK;
import terain.entities.Terain;
import terain.entities.Ville;
import terain.entities.Zone;

@Local
public interface TerainLocal{
	public Ville addVille(Ville ville);
	public List<Ville> villeListe();
	public void deleteVille(int id);
	public Ville findVille(int id);
	public void UpdateVille(Ville ville);
	
	public Pack addPack(Pack pack);
	public List<Pack> packListe();
	public void deletePack(int id);
	public Pack findPack(int id);
	public void UpdatePack(Pack pack);
	public boolean isExistClubs(int id);
	public void deleteAllClubs(int id);
	
	public Zone addZone(String nom,Ville v);
	public List<Zone> zoneListe();
	public void deleteZone(int id);
	public Zone findZone(int id);
	public void UpdateZone(Zone zone,Ville v,String nom);
	public boolean isExistZones(int id);
	public void deleteAllZones(int id);
	public boolean isExistTerains(int id);
	public void deleteAllTerains(int id);
	public boolean isExistTerainsP(int id);
	public void deleteAllTerainsP(int id);
	
	public Terain addTerain(String nom,String type,Zone zone,Club club,double longitude,double latitude,int capacite);
	public List<Terain> terainListe();
	public void deleteTerain(int id);
	public Terain findTerain(int id);
	public void UpdateTerain(int id,String nom,String type,Zone zone,Club club,double longitude,double latitude,int capacite);
	
	public Club addClub(String nom,String type ,Pack pack);
	public List<Club> clubListe();
	public void deleteClub(int id);
	public Club findClub(int id);
	public void UpdateClub(int id,String nom,String type ,Pack pack);

	public Client addClient(Client client);
	public List<Client> clientListe();
	public void deleteClient(int id);
	public Client findClient(int id);
	public void UpdateClient(Client client);
	
	public Abonment addAbonment(String descri,int duree, Date date, Pack pack,Client client);
	public List<Abonment> abonmentListe();
	public void deleteAbonment(int id);
	public Abonment findAbonment(int id);
	public void UpdateAbonment(int id,String descri,int duree, Date date, Pack pack,Client client);
	
	public Reservation addReservation(int duree,Date date, Client client,Terain terain);
	public List<Reservation> reservationListe();
	public void deleteReservation(int id);
	public Ville findReservation(int id);
	public void UpdateReservation(ReservationPK pk,int duree,Date date, Client client,Terain terain);
}

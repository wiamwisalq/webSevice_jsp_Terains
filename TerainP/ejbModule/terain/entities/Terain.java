package terain.entities;

import java.io.Serializable;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Terain
 *
 */
@Entity

public class Terain implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	private double latitude;
	private double longitude;
	private String nom;
	private int capacite;
	private String type;
	
	@ManyToOne(cascade = CascadeType.PERSIST) 
	@JoinColumn(name="idZone")
	private Zone zone;
	
	@ManyToOne(cascade = CascadeType.PERSIST) 
	@JoinColumn(name="idClub")
	private Club club;
	
	
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name="club-terain",
//	joinColumns = @JoinColumn(name="idTerain"),
//	inverseJoinColumns = @JoinColumn(name="idClub")
//			)
//	List<Club> clubs;
	
	private static final long serialVersionUID = 1L;

	public Terain() {
		super();
	} 
	public Terain(double lat,double longitude,String nom, int cap,String type,Zone zone,Club club) {
		super();
		this.latitude=lat;
		this.longitude=longitude;
		this.nom=nom;
		this.capacite=cap;
		this.type=type;
		this.zone=zone;
		this.club=club;
	} 
	public Terain(double lat,double longitude,String nom, int cap,String type) {
		super();
		this.latitude=lat;
		this.longitude=longitude;
		this.nom=nom;
		this.capacite=cap;
		this.type=type;
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}   
	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public int getCapacite() {
		return this.capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	public Club getClub() {
		return club;
	}
	public void setClub(Club club) {
		this.club = club;
	}

   
}

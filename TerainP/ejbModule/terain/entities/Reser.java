package terain.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	private Date date_res;
	private int duree;
	@ManyToOne(cascade = CascadeType.PERSIST) 
	@JoinColumn(name="idClient")
	private Client client;
	@ManyToOne(cascade = CascadeType.PERSIST) 
	@JoinColumn(name="idTerain")
	private Terain terain;
	
	public Reser() {
		super();
	}
	public Reser(Date date_res, int duree, Client client, Terain terain) {
		super();
		this.id = id;
		this.date_res = date_res;
		this.duree = duree;
		this.client = client;
		this.terain = terain;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate_res() {
		return date_res;
	}
	public void setDate_res(Date date_res) {
		this.date_res = date_res;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Terain getTerain() {
		return terain;
	}
	public void setTerain(Terain terain) {
		this.terain = terain;
	}
	
}


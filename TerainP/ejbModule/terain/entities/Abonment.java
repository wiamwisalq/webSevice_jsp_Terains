package terain.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Abonment
 *
 */
@Entity
public class Abonment implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String desciption;
	private int duree;
	private Date date;
	@ManyToOne(cascade = CascadeType.PERSIST) 
	@JoinColumn(name="idPack", nullable=false)
	private Pack pack;
	@ManyToOne(cascade = CascadeType.PERSIST) 
	@JoinColumn(name="idClient", nullable=false)
	private Client client;
	private static final long serialVersionUID = 1L;

	public Abonment() {
		super();
	} 
	public Abonment(String descri,int duree, Date date, Pack pack,Client client) {
		super();
		this.desciption=descri;
		this.duree=duree;
		this.date=date;
		this.pack=pack;
		this.client=client;
	}  
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getDesc() {
		return this.desciption;
	}

	public void setDesc(String desc) {
		this.desciption = desc;
	}   
	public int getDuree() {
		return this.duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public Pack getPack() {
		return pack;
	}
	public void setPack(Pack pack) {
		this.pack = pack;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
   
}

package terain.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pack
 *
 */
@Entity

public class Pack implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	private double prix;
	private int nbr;
	
	private static final long serialVersionUID = 1L;

	public Pack() {
		super();
	}
	public Pack(String description, double prix,int nbr) {
		super();
		this.description=description;
		this.prix=prix;
		this.nbr=nbr;
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getDesc() {
		return this.description;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}   
	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}   
	public int getNbr() {
		return this.nbr;
	}

	public void setNbr(int nbr) {
		this.nbr = nbr;
	}
   
}

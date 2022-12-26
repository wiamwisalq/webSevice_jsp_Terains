package terain.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Club
 *
 */
@Entity

public class Club implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String type;
	@ManyToOne(cascade = CascadeType.PERSIST) 
	@JoinColumn(name="idPack")
	private Pack pack;
	
	private static final long serialVersionUID = 1L;

	public Club() {
		super();
	} 
	public Club(String nom,String type,Pack pack) {
		super();
		this.nom=nom;
		this.type=type;
		this.pack=pack;
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public Pack getPack() {
		return pack;
	}
	public void setPack(Pack pack) {
		this.pack = pack;
	}
   
}

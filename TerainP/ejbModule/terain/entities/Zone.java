package terain.entities;


import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.*;





/**
 * Entity implementation class for Entity: Zone
 *
 */
@Entity

public class Zone implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="idVille") //, nullable=false
	private Ville ville;
	
//	@OneToMany( targetEntity=Terain.class, mappedBy="zone" )
//  private List<Terain> terains = new ArrayList<>();
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}

	private static final long serialVersionUID = 1L;

	public Zone() {
		super();
	}   
	public Zone(String nom,Ville ville) {
		super();
		this.nom=nom;
		this.ville=ville;
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
//	public List<Terain> getTerains() {
//		return terains;
//	}
//	public void setTerains(List<Terain> terains) {
//		this.terains = terains;
//	}
   
}

//<property name="javax.persistence.schema-generation.database.action"  value="drop-and-create"/>

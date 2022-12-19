package terain.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ville
 *
 */
@Entity
public class Ville implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
//	@OneToMany(fetch = FetchType.EAGER,targetEntity=Zone.class, mappedBy="ville",cascade = CascadeType.ALL )
//    private List<Zone> zones = new ArrayList<>();
//	@OneToMany( targetEntity=Zone.class, mappedBy="ville" )
//    private List<Zone> z = new ArrayList<>();
	private static final long serialVersionUID = 1L;
	public Ville() {
		super();
	}  
	public Ville(String nom) {
		super();
		this.nom=nom;
	} 
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
   
}

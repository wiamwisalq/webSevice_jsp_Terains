package terain.entities;

import java.io.Serializable;
import javax.persistence.*;
import terain.entities.ReservationPK;

/**
 * Entity implementation class for Entity: Reservation
 *
 */
@Entity
public class Reservation implements Serializable {

	@EmbeddedId
	private ReservationPK pk;
	private int duree;
	@ManyToOne
	@JoinColumn(name = "client", insertable = false, updatable = false )
	private Client client;
	@ManyToOne
	@JoinColumn(name = "terain", insertable = false, updatable = false)
	private Terain service;
	private static final long serialVersionUID = 1L;

	public Reservation(ReservationPK pk,int duree) {
		super();
	}   
	public Reservation() {
		super();
	}   
	public ReservationPK getPk() {
		return this.pk;
	}

	public void setPk(ReservationPK pk) {
		this.pk = pk;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	
   
}

package terain.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ReservationPK
 *
 */
@Embeddable
public class ReservationPK implements Serializable {

	
	private int client;
	private int terain;
	private Date date_res;
	
	
	private static final long serialVersionUID = 1L;

	public ReservationPK() {
		super();
	} 
	public ReservationPK(int client,int terain,Date date) {
		super();
		this.client=client;
		this.terain=terain;
		this.date_res=date;
	}
	public Date getDate_res() {
		return date_res;
	}
	public void setDate_res(Date date_res) {
		this.date_res = date_res;
	}
	

  
	public int getClient() {
		return this.client;
	}

	public void setClient(int client) {
		this.client = client;
	}   
	public int getTerain() {
		return this.terain;
	}

	public void setTerain(int terain) {
		this.terain = terain;
	}
	@Override
	public int hashCode() {
		return Objects.hash(client, date_res, terain);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservationPK other = (ReservationPK) obj;
		return client == other.client && Objects.equals(date_res, other.date_res)
				&& terain == other.terain;
	}
   
}

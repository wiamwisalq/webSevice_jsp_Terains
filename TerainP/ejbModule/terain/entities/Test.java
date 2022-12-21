package terain.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Test
 *
 */
@Entity

public class Test implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nbr;
	private String tes;
	private String tes1;
	private static final long serialVersionUID = 1L;

	public Test() {
		super();
	}   
	public String getTes() {
		return this.tes;
	}

	public void setTes(String tes) {
		this.tes = tes;
	}
	public String getTes1() {
		return tes1;
	}
	public void setTes1(String tes1) {
		this.tes1 = tes1;
	}
   
}

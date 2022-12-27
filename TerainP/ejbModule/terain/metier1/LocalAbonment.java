package terain.metier1;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import terain.entities.Abonment;
import terain.entities.Client;
import terain.entities.Pack;

@Local
public interface LocalAbonment {
	public Abonment addAbonment(String descri,int duree, Date date, Pack pack,Client client);
	public List<Abonment> abonmentListe();
	public void deleteAbonment(int id);
	public Abonment findAbonment(int id);
	public void UpdateAbonment(int id,String descri,int duree, Date date, Pack pack,Client client);
}

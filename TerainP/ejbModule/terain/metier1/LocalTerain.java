package terain.metier1;

import java.util.List;

import javax.ejb.Local;

import terain.entities.Club;
import terain.entities.Terain;
import terain.entities.Zone;
@Local
public interface LocalTerain {
	public Terain addTerain(String nom,String type,Zone zone,Club club,double longitude,double latitude,int capacite);
	public List<Terain> terainListe();
	public void deleteTerain(int id);
	public Terain findTerain(int id);
	public void UpdateTerain(int id,String nom,String type,Zone zone,Club club,double longitude,double latitude,int capacite);
	
}

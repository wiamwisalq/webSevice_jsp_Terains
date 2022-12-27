package terain.metier1;

import java.util.List;

import javax.ejb.Local;

import terain.entities.Club;
import terain.entities.Pack;

@Local
public interface LocalClub {
	public Club addClub(String nom,String type ,Pack pack);
	public List<Club> clubListe();
	public void deleteClub(int id);
	public Club findClub(int id);
	public void UpdateClub(int id,String nom,String type ,Pack pack);
}

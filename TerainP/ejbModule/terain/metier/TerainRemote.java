package terain.metier;

import java.util.List;

import javax.ejb.Remote;

import terain.entities.Ville;
import terain.entities.Zone;

@Remote
public interface TerainRemote {
	public Ville addVille(Ville ville);
	public List<Ville> villeListe();
	public void deleteVille(int id);
	public Ville findVille(int id);
	public void UpdateVille(Ville ville);
	
	public Zone addZone(String nom,Ville v);
	public List<Zone> zoneListe();
	public void deleteZone(int id);
	public Zone findZone(int id);
	public void UpdateZone(Zone zone);
}

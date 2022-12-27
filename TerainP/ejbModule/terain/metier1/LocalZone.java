package terain.metier1;

import java.util.List;

import javax.ejb.Local;

import terain.entities.Ville;
import terain.entities.Zone;
@Local
public interface LocalZone {
	public Zone addZone(String nom,Ville v);
	public List<Zone> zoneListe();
	public void deleteZone(int id);
	public Zone findZone(int id);
	public void UpdateZone(Zone zone,Ville v,String nom);
	public boolean isExistZones(int id);
	public void deleteAllZones(int id);
	public boolean isExistTerains(int id);
	public void deleteAllTerains(int id);
	public boolean isExistTerainsP(int id);
	public void deleteAllTerainsP(int id);

}

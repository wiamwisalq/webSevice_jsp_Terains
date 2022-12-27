package terain.metier1;

import java.util.List;

import javax.ejb.Local;

import terain.entities.Pack;

@Local
public interface LocalPack {
	public Pack addPack(Pack pack);
	public List<Pack> packListe();
	public void deletePack(int id);
	public Pack findPack(int id);
	public void UpdatePack(Pack pack);
	public boolean isExistClubs(int id);
	public void deleteAllClubs(int id);
}

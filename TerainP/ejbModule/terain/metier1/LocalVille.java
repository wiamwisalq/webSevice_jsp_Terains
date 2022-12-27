package terain.metier1;

import java.util.List;

import javax.ejb.Local;

import terain.entities.Ville;

@Local
public interface LocalVille {
	public Ville addVille(Ville ville);
	public List<Ville> villeListe();
	public void deleteVille(int id);
	public Ville findVille(int id);
	public void UpdateVille(Ville ville);
}

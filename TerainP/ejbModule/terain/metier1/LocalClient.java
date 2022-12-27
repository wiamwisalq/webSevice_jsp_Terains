package terain.metier1;

import java.util.List;

import javax.ejb.Local;

import terain.entities.Client;

@Local
public interface LocalClient {
	public Client addClient(Client client);
	public List<Client> clientListe();
	public void deleteClient(int id);
	public Client findClient(int id);
	public void UpdateClient(Client client);
}

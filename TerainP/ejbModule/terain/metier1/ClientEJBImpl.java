package terain.metier1;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import terain.entities.Client;

@Stateless(name = "Client") 
public class ClientEJBImpl implements LocalClient{
	@PersistenceContext   
	private EntityManager em;
	@Override
	public Client addClient(Client client) {
		em.persist(new Client(client.getNom(),client.getType()));
		return client;
	}

	@Override
	public List<Client> clientListe() {
		Query req=em.createQuery("from Client");
		return req.getResultList();
	}

	@Override
	public void deleteClient(int id) {
		// TODO Auto-generated method stub
		em.remove(em.find(Client.class, id));
	}

	@Override
	public Client findClient(int id) {
		// TODO Auto-generated method stub	
		return em.find(Client.class,id);
	}

	@Override
	public void UpdateClient(Client client) {
		// TODO Auto-generated method stub
		Client c= em.find(Client.class, client.getId());
		c.setNom(client.getNom());
		c.setType(client.getType());
		em.persist(c);
	}

}

package terain.metier;

import java.util.List;

import terain.entities.Ville;

public interface Local<T> {
	public T add(T obj);
	public List<T> Liste();
	public void delete(int id);
	public T find(int id);
	public void Update(T obj);
}

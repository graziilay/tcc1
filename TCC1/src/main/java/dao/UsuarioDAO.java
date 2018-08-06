package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Usuario;

public class UsuarioDAO {

	private EntityManager manager;

	public UsuarioDAO() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("banco");
		manager = factory.createEntityManager();
	}

	public void save(Usuario usuario) throws PersistenciaDacException {
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
	}

	public void update(Usuario usuario) throws PersistenciaDacException {
		manager.getTransaction().begin();
		manager.merge(usuario);
		manager.getTransaction().commit();
	}

	public void delete(Integer id) throws PersistenciaDacException {
		manager.getTransaction().begin();
		Usuario usuario = manager.find(Usuario.class, id);
		manager.remove(usuario);
		manager.getTransaction().commit();
	}

	public Usuario getByID(int usuarioId) throws PersistenciaDacException {
		return manager.find(Usuario.class, usuarioId);
	}
	
	public List<Usuario> list() throws PersistenciaDacException {
		Query query = manager.createQuery("from Usuario", Usuario.class);
		return query.getResultList();
	}
}

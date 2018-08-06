package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entidades.Comentario;

public class ComentarioDAO {

	private EntityManager manager;

	public ComentarioDAO() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("banco");
		manager = factory.createEntityManager();
	}

	public void save(Comentario comentario) throws PersistenciaDacException {
		manager.getTransaction().begin();
		manager.persist(comentario);
		manager.getTransaction().commit();
	}

	public void update(Comentario comentario) throws PersistenciaDacException {
		manager.getTransaction().begin();
		manager.merge(comentario);
		manager.getTransaction().commit();
	}

	public void delete(Integer id) throws PersistenciaDacException {
		manager.getTransaction().begin();
		Comentario comentario = manager.find(Comentario.class, id);
		manager.remove(comentario);
		manager.getTransaction().commit();
	}

	public Comentario getByID(int comentarioId) throws PersistenciaDacException {
		return manager.find(Comentario.class, comentarioId);
	}

}

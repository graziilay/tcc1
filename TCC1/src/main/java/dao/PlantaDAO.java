package dao;

import java.awt.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entidades.Planta;
import entidades.Usuario;

public class PlantaDAO {

	private EntityManager manager;

	public PlantaDAO() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("banco");
		manager = factory.createEntityManager();
	}

	public void save(Planta planta) throws PersistenciaDacException {
		manager.getTransaction().begin();
		manager.persist(planta);
		manager.getTransaction().commit();
	}

	public void update(Planta planta) throws PersistenciaDacException {
		manager.getTransaction().begin();
		manager.merge(planta);
		manager.getTransaction().commit();
	}

	public void delete(Integer id) throws PersistenciaDacException {
		manager.getTransaction().begin();
		Planta planta = manager.find(Planta.class, id);
		manager.remove(planta);
		manager.getTransaction().commit();
	}

	public Planta getByID(int plantaId) throws PersistenciaDacException {
		return manager.find(Planta.class, plantaId);
	}

	public List<Planta> list() throws PersistenciaDacException {
		Query query = manager.createQuery("from Usuario", Planta.class);
		return query.getResultList();
	}
}

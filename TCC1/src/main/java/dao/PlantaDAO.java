package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entidades.Planta;

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

}

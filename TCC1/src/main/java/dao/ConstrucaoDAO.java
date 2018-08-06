package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entidades.Construcao;

public class ConstrucaoDAO {

	private EntityManager manager;

	public ConstrucaoDAO() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("banco");
		manager = factory.createEntityManager();
	}

	public void save(Construcao construcao) throws PersistenciaDacException {
		manager.getTransaction().begin();
		manager.persist(construcao);
		manager.getTransaction().commit();
	}

	public void update(Construcao construcao) throws PersistenciaDacException {
		manager.getTransaction().begin();
		manager.merge(construcao);
		manager.getTransaction().commit();
	}

	public void delete(Integer id) throws PersistenciaDacException {
		manager.getTransaction().begin();
		Construcao construcao = manager.find(Construcao.class, id);
		manager.remove(construcao);
		manager.getTransaction().commit();
	}

	public Construcao getByID(int construcaoId) throws PersistenciaDacException {
		return manager.find(Construcao.class, construcaoId);
	}
}

package dao;

import java.util.List;
import javax.persistence.Query;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import entidades.Construcao;
import entidades.Usuario;

@ApplicationScoped
public class ConstrucaoDAO {

	@Inject
	private EntityManager manager;

	public void save(Construcao construcao) throws PersistenciaDacException {
		if (construcao.getId_construcao() == null) {
			manager.persist(usuario);
		} else {
			update(usuario);
		}
	}

	public Usuario update(Usuario usuario) throws PersistenciaDacException {
		Usuario resultado = usuario;
		resultado = manager.merge(usuario);
		return resultado;
	}

	public void delete(Usuario usuario) throws PersistenciaDacException {
		usuario = getByID(usuario.getId_usuario());
		manager.remove(usuario);
	}

	public Usuario getByID(int usuarioId) throws PersistenciaDacException {
		return manager.find(Usuario.class, usuarioId);
	}
	
	public List<Usuario> list() throws PersistenciaDacException {
		Query query = manager.createQuery("from Usuario", Usuario.class);
		return query.getResultList();
	}
}
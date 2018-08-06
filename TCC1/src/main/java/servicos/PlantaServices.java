package servicos;

import java.io.Serializable;
import dao.PersistenciaDacException;
import dao.PlantaDAO;
import entidades.Planta;

public class PlantaServices implements Serializable {

	private static final long serialVersionUID = -7803325791425670859L;

	private PlantaDAO dao = new PlantaDAO();

	public void save(Planta user) throws ServiceDacException {
		try {
			dao.save(user);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	public void update(Planta user) throws ServiceDacException {

		try {
			dao.update(user);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	public void delete(Integer id) throws ServiceDacException {
		try {
			dao.delete(id);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	public Planta getByID(int userId) throws ServiceDacException {
		try {
			return dao.getByID(userId);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}
}

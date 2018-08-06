package servicos;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

import dao.PersistenciaDacException;
import dao.UsuarioDAO;
import entidades.Usuario;

public class UsuarioServices implements Serializable {

	private static final long serialVersionUID = -7803325791425670859L;

	private UsuarioDAO dao = new UsuarioDAO();

	public void save(Usuario user) throws ServiceDacException {
		try {
			dao.save(user);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	public void update(Usuario user) throws ServiceDacException {

		try {
			dao.update(user);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	public void delete(Integer user) throws ServiceDacException {
		try {
			dao.delete(user);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	public Usuario getByID(int userId) throws ServiceDacException {
		try {
			return dao.getByID(userId);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	public List<Usuario> list() throws ServiceDacException {
		try {
			return dao.list();
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	public String calcularHashDaSenha(Usuario user) throws ServiceDacException {
		user.setSenha(hash(user.getSenha()));
		return user.getSenha();
	}

	public String calcularHash(String password) throws ServiceDacException {
		return hash(password);
	}

	private static String hash(String password) throws ServiceDacException {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes("UTF-8"));
			byte[] digest = md.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			String output = bigInt.toString(16);
			return output;
		} catch (Exception e) {
			throw new ServiceDacException("Could not calculate hash!", e);
		}
	}
}

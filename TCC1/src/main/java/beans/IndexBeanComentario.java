package beans;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import entidades.Comentario;
import servicos.ComentarioServices;
import servicos.ServiceDacException;

@Named
@SessionScoped
public class IndexBeanComentario {

	private ComentarioServices service = new ComentarioServices();

	private Comentario comentario;

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	public void adicionarComentario() throws ServiceDacException {
		service.save(comentario);
		comentario = new Comentario();
	}

	public void editarComentario(Integer id) throws ServiceDacException {
		service.update(comentario);
	}

	public void removerComentario() throws ServiceDacException {
		Integer id = comentario.getId_comentario();
		service.delete(id);
	}

	public IndexBeanComentario() {
		comentario = new Comentario();
	}

}

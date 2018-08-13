package beans;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import entidades.Construcao;
import servicos.ConstrucaoServices;
import servicos.ServiceDacException;

@Named
@SessionScoped
public class IndexBeanConstrucao {

	private ConstrucaoServices service = new ConstrucaoServices();
	private Construcao construcao;

	public Construcao getConstrucao() {
		return construcao;
	}

	public void setConstrucao(Construcao construcao) {
		this.construcao = construcao;
	}

	public void adicionarConstrucao() throws ServiceDacException {
		service.save(construcao);
		construcao = new Construcao();
	}

	public void editarConstrucao() throws ServiceDacException {
		service.update(construcao);
	}

	public void removerConstrucao() throws ServiceDacException {
		Integer id = construcao.getId_construcao();
		service.delete(id);
	}

	public IndexBeanConstrucao() {
		construcao = new Construcao();
	}

}

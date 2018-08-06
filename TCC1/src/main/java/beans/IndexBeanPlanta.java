package beans;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Planta;
import servicos.PlantaServices;
import servicos.ServiceDacException;

@ManagedBean
@SessionScoped
public class IndexBeanPlanta {

	private PlantaServices service = new PlantaServices();
	// private StreamedContent file;
	private Planta planta;

	public Planta getPlanta() {
		return planta;
	}

	public void setPlanta(Planta planta) {
		this.planta = planta;
	}

	public void adicionarPlanta() throws ServiceDacException {
		service.save(planta);
		planta = new Planta();
	}

	public void editarPlanta() throws ServiceDacException {
		service.update(planta);
	}

	public void removerPlanta() throws ServiceDacException {
		Integer id = planta.getId_planta();
		service.delete(id);
	}

	public IndexBeanPlanta() {
		planta = new Planta();
		Date data = new Date(System.currentTimeMillis());
		// InputStream stream =
		// FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/demo/images/boromir.jpg");
		// file = new DefaultStreamedContent(stream, "image/jpg",
		// "downloaded_boromir.jpg");
	}

	// public StreamedContent getFile() {
	// return file;
	// }
}

package entidades;

import java.io.File;
import java.sql.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "planta")
@Entity
public class Planta {

	static private int cont;
	@Id
	private int id_planta;
	private String construido;
	@Column(name = "descricao_auditiva")
	private File descricaoauditiva;
	@Column(name = "descricao_textual")
	private String descricaotextual;
	private Date data;
	private String avaliacao;
	@OneToMany
	private Set<Comentario> comentarios;

	public Planta() {
		this.id_planta = cont;
		cont++;
	}

	public Planta(int id_planta, String construido, File descricaoauditiva, String descricaotextual, Date data,
			String avaliacao, Set<Comentario> comentarios) {
		this.id_planta = id_planta;
		this.construido = construido;
		this.descricaoauditiva = descricaoauditiva;
		this.descricaotextual = descricaotextual;
		this.data = data;
		this.avaliacao = avaliacao;
		this.comentarios = comentarios;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public int getId_planta() {
		return id_planta;
	}

	public void setId_planta(int id_planta) {
		this.id_planta = id_planta;
	}

	public String getConstruido() {
		return construido;
	}

	public void setConstruido(String construido) {
		this.construido = construido;
	}

	public File getDescricaoauditiva() {
		return descricaoauditiva;
	}

	public void setDescricaoauditiva(File descricaoauditiva) {
		this.descricaoauditiva = descricaoauditiva;
	}

	public String getDescricaotextual() {
		return descricaotextual;
	}

	public void setDescricaotextual(String descricaotextual) {
		this.descricaotextual = descricaotextual;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Planta clone() {
		return new Planta(id_planta, construido, descricaoauditiva, descricaotextual, data, avaliacao, comentarios);
	}
}

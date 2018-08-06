package entidades;

import java.io.File;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "comentario")
@Entity
public class Comentario {

	static private int cont;
	@Id
	private Integer id_comentario;
	private File audio;
	private String texto;
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Comentario() {
		this.id_comentario = cont;
		cont++;
	}

	public Comentario(Integer id_comentario, File audio, String texto, Usuario usuario) {
		super();
		this.id_comentario = id_comentario;
		this.audio = audio;
		this.texto = texto;
		this.usuario = usuario;
	}

	public Integer getId_comentario() {
		return id_comentario;
	}

	public void setId_comentario(int id_comentario) {
		this.id_comentario = id_comentario;
	}

	public File getAudio() {
		return audio;
	}

	public void setAudio(File audio) {
		this.audio = audio;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Comentario clone() {
		return new Comentario(id_comentario, audio, texto, usuario);
	}

}

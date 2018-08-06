package entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "construcao")
@Entity
public class Construcao {

	static private int cont;
	@Id
	private int id_construcao;
	private String finalidade;
	private String endereco;
	private String nome;
	@OneToOne
	@JoinColumn(name="id_usuario")
	private Usuario dono;
	@OneToOne
	@JoinColumn(name="id_planta")
	private Planta planta;

	public Construcao() {
		this.id_construcao = cont;
		cont++;
	}

	public Construcao(int id_construcao, String finalidade, String endereco, String nome, Usuario dono, Planta planta) {
		this.id_construcao = id_construcao;
		this.finalidade = finalidade;
		this.endereco = endereco;
		this.nome = nome;
		this.dono = dono;
		this.planta = planta;
	}

	public Usuario getDono() {
		return dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
	}

	public int getId_construcao() {
		return id_construcao;
	}

	public void setId_construcao(int id_construcao) {
		this.id_construcao = id_construcao;
	}

	public String getFinalidade() {
		return finalidade;
	}

	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereço) {
		this.endereco = endereço;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Planta getPlanta() {
		return planta;
	}

	public void setPlanta(Planta planta) {
		this.planta = planta;
	}

	public Construcao clone() {
		return new Construcao(id_construcao, finalidade, endereco, nome, dono, planta);
	}
}

package br.com.fiap.smartcities.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_SIP_DEPARTAMENTO")
public class Departamento {
	
	@Id
	@SequenceGenerator(name = "departamento", sequenceName = "sq_departamento", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departamento")
	
	@Column(name = "id_departamento")
	private int id;
	
	@Column(name = "nm_departamento", nullable = false, length = 50)
	private String nome;
	
	@OneToMany(mappedBy = "departamento",cascade=CascadeType.PERSIST)
	private List<Colaborador> colaborador;
	
	public Departamento() {}

	public Departamento(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Colaborador> getColaborador() {
		return colaborador;
	}

	public void setColaborador(List<Colaborador> colaborador) {
		this.colaborador = colaborador;
	}
}

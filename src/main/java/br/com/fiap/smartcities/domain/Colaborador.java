package br.com.fiap.smartcities.domain;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_SIP_COLABORADOR")
public class Colaborador {

	@Id 
	@Column(name = "id_colaborador")
	//depois perguntar se aqui iria um gerador de sequencia
	@SequenceGenerator(name = "colaborador", sequenceName = "sq_colaborador", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "colaborador")
	private int id;
	
	@Column(name = "nm_colaborador", nullable = false, length = 50)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_admissao", nullable = false)
	private Calendar dataAdmissao;
	
	@Column(name = "ds_endereco", nullable = false, length = 50)
	private String endereco;
	
	@Column(name = "vl_salario", nullable = false)
	private float salario;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "id_estabelecimento")
	private Estabelecimento estabelecimento; 
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "id_departamento")
	private Departamento departamento;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "id_contrato")
	private Contrato contrato;


	public Colaborador() {}


	public Colaborador(int id, String nome, Calendar dataAdmissao, String endereco, float salario,
			Estabelecimento estabelecimento, Departamento departamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.endereco = endereco;
		this.salario = salario;
		this.estabelecimento = estabelecimento;
		this.departamento = departamento;
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


	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}


	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public float getSalario() {
		return salario;
	}


	public void setSalario(float salario) {
		this.salario = salario;
	}


	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}


	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}


	public Departamento getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}

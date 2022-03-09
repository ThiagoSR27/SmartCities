package br.com.fiap.smartcities.domain;

import java.io.Serializable;
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

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "T_SIP_PROJETO")
public class Projeto implements Serializable{
	
	@Id
	@SequenceGenerator(name = "projeto", sequenceName = "sq_projeto", allocationSize = 1)
	@GeneratedValue(generator = "projeto", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_projeto")
	private int id;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "id_acao_social")
	private Tipo tipo;
	
	@Column(name = "nm_projeto", nullable = false, length = 50)
	private String nome_projeto;
	
	@Column(name = "ds_projeto", nullable = true, length = 100)
	private String desc_projeto;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_inicio", nullable = false)
	private Calendar dt_inicio;
	
	@UpdateTimestamp
	@Column(name = "dt_termino", nullable = true)
	private Calendar dt_termino;

	public Projeto(int id, Tipo tipo, String nome_projeto, String desc_projeto, Calendar dt_inicio,
			Calendar dt_termino) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nome_projeto = nome_projeto;
		this.desc_projeto = desc_projeto;
		this.dt_inicio = dt_inicio;
		this.dt_termino = dt_termino;
	}

	public Projeto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getNome_projeto() {
		return nome_projeto;
	}

	public void setNome_projeto(String nome_projeto) {
		this.nome_projeto = nome_projeto;
	}

	public String getDesc_projeto() {
		return desc_projeto;
	}

	public void setDesc_projeto(String desc_projeto) {
		this.desc_projeto = desc_projeto;
	}

	public Calendar getDt_inicio() {
		return dt_inicio;
	}

	public void setDt_inicio(Calendar dt_inicio) {
		this.dt_inicio = dt_inicio;
	}

	public Calendar getDt_termino() {
		return dt_termino;
	}

	public void setDt_termino(Calendar dt_termino) {
		this.dt_termino = dt_termino;
	}
	
	
	
	
}

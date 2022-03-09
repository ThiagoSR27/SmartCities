package br.com.fiap.smartcities.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "T_SIP_IMPLANTACAO")
@IdClass(ImplantacaoId.class)
public class Implantacao implements Serializable{
	
	@Id
	@SequenceGenerator(name = "implantacao", sequenceName = "sq_implantacao", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "implantacao")
	@Column(name = "id_implantacao")
	private int id;
	
	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "id_projeto")
	private Projeto projeto;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "id_colaborador")
	private Colaborador colaborador;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_entrada", nullable = false)
	private Calendar dt_entrada;
	
	//@Temporal(TemporalType.DATE)
	@UpdateTimestamp
	@Column(name = "dt_saida", nullable = true)
	private Calendar dt_saida;

	public Implantacao(int id, Projeto projeto, Colaborador colaborador, Calendar dt_entrada, Calendar dt_saida) {
		super();
		this.id = id;
		this.projeto = projeto;
		this.colaborador = colaborador;
		this.dt_entrada = dt_entrada;
		this.dt_saida = dt_saida;
	}

	public Implantacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Calendar getDt_entrada() {
		return dt_entrada;
	}

	public void setDt_entrada(Calendar dt_entrada) {
		this.dt_entrada = dt_entrada;
	}

	public Calendar getDt_saida() {
		return dt_saida;
	}

	public void setDt_saida(Calendar dt_saida) {
		this.dt_saida = dt_saida;
	}
	
	
}

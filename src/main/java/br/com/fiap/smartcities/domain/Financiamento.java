package br.com.fiap.smartcities.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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

@Entity
@Table(name = "T_SIP_FINANCIAMENTO")
@IdClass(FinanciamentoId.class)
public class Financiamento implements Serializable {

	@Id
	@SequenceGenerator(name = "financiamento", sequenceName = "sq_financiamento", allocationSize = 1)
	@GeneratedValue(generator = "financiamento", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_financiamento")
	private int id;
	
	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "id_parceiro")
	private Parceiro parceiro;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "id_estabelecimento")
	private Estabelecimento estabelecimento;
	
	@Column(name = "ds_tp_financiamento", nullable = false, length = 50)
	private String desc_tipo_financiamento;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_contratacao", nullable = false)
	private Calendar dt_contratacao;
	
	@Column(name = "vl_investimento", nullable = false)
	private float vl_investimento;
	
	

	public Financiamento(int id, Parceiro parceiro, Estabelecimento estabelecimento, String desc_tipo_financiamento,
			Calendar dt_contratacao, float vl_investimento) {
		super();
		this.id = id;
		this.parceiro = parceiro;
		this.estabelecimento = estabelecimento;
		this.desc_tipo_financiamento = desc_tipo_financiamento;
		this.dt_contratacao = dt_contratacao;
		this.vl_investimento = vl_investimento;
	}

	public Financiamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Parceiro getParceiro() {
		return parceiro;
	}

	public void setParceiro(Parceiro parceiro) {
		this.parceiro = parceiro;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public String getDesc_tipo_financiamento() {
		return desc_tipo_financiamento;
	}

	public void setDesc_tipo_financiamento(String desc_tipo_financiamento) {
		this.desc_tipo_financiamento = desc_tipo_financiamento;
	}

	public Calendar getDt_contratacao() {
		return dt_contratacao;
	}

	public void setDt_contratacao(Calendar dt_contratacao) {
		this.dt_contratacao = dt_contratacao;
	}

	public float getVl_investimento() {
		return vl_investimento;
	}

	public void setVl_investimento(float vl_investimento) {
		this.vl_investimento = vl_investimento;
	}
	
	
	
	
}

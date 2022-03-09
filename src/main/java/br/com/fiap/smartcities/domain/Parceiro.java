package br.com.fiap.smartcities.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "T_SIP_PARCEIRO")
public class Parceiro implements Serializable{

	@Id
	@SequenceGenerator(name = "parceiro", sequenceName = "sq_parceiro", allocationSize = 1)
	@GeneratedValue(generator = "parceiro", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_parceiro")
	private int id;
	
	@Column(name = "nm_parceiro", nullable = false, length = 50)
	private String nome_parceiro;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_celebracao_parceria", nullable = false)
	private Calendar dt_celebracao_parceria;
	
	@UpdateTimestamp
	@Column(name = "dt_fim_parceria")
	private Calendar dt_fim_parceria;

	public Parceiro(int id, String nome_parceiro, Calendar dt_celebracao_parceria, Calendar dt_fim_parceria) {
		super();
		this.id = id;
		this.nome_parceiro = nome_parceiro;
		this.dt_celebracao_parceria = dt_celebracao_parceria;
		this.dt_fim_parceria = dt_fim_parceria;
	}

	public Parceiro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_parceiro() {
		return nome_parceiro;
	}

	public void setNome_parceiro(String nome_parceiro) {
		this.nome_parceiro = nome_parceiro;
	}

	public Calendar getDt_celebracao_parceria() {
		return dt_celebracao_parceria;
	}

	public void setDt_celebracao_parceria(Calendar dt_celebracao_parceria) {
		this.dt_celebracao_parceria = dt_celebracao_parceria;
	}

	public Calendar getDt_fim_parceria() {
		return dt_fim_parceria;
	}

	public void setDt_fim_parceria(Calendar dt_fim_parceria) {
		this.dt_fim_parceria = dt_fim_parceria;
	}
	
	
}

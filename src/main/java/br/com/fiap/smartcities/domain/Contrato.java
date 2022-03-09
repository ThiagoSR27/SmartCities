package br.com.fiap.smartcities.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_SIP_CONTRATO")
public class Contrato {

	@Id
	@SequenceGenerator(name = "contrato",sequenceName = "sq_contrato", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contrato")
	@Column(name = "id_contrato")
	private int id;
	
	@Column(name = "nm_vinculo_empregaticio", nullable = false, length = 50)
	private String vinculo_empregaticio;
	
	@Column(name = "nm_funcao", nullable = false, length = 50)
	private String funcao;
	
	@Column(name = "ds_funcao", nullable = true, length = 50)
	private String descricao_funcao;

	public Contrato(int id, String vinculo_empregaticio, String funcao, String descricao_funcao) {
		super();
		this.id = id;
		this.vinculo_empregaticio = vinculo_empregaticio;
		this.funcao = funcao;
		this.descricao_funcao = descricao_funcao;
	}

	public Contrato() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVinculo_empregaticio() {
		return vinculo_empregaticio;
	}

	public void setVinculo_empregaticio(String vinculo_empregaticio) {
		this.vinculo_empregaticio = vinculo_empregaticio;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getDescricao_funcao() {
		return descricao_funcao;
	}

	public void setDescricao_funcao(String descricao_funcao) {
		this.descricao_funcao = descricao_funcao;
	}
	
	
}

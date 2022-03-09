package br.com.fiap.smartcities.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_SIP_TIPO")
public class Tipo {

	@Id
	@SequenceGenerator(name = "tipo", sequenceName = "sq_tipo", allocationSize = 1)
	@GeneratedValue(strategy =GenerationType.SEQUENCE, generator = "tipo" )
	@Column(name = "id_acao_social")
	private int id;
	
	@Column(name = "nm_tp_acao_social", nullable = false, length = 50)
	private String to_acao_social;
	
	@Column(name = "ds_acao_social", nullable = true, length = 50)
	private String desc_acao_social;

	public Tipo(int id, String to_acao_social, String desc_acao_social) {
		super();
		this.id = id;
		this.to_acao_social = to_acao_social;
		this.desc_acao_social = desc_acao_social;
	}

	public Tipo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTo_acao_social() {
		return to_acao_social;
	}

	public void setTo_acao_social(String to_acao_social) {
		this.to_acao_social = to_acao_social;
	}

	public String getDesc_acao_social() {
		return desc_acao_social;
	}

	public void setDesc_acao_social(String desc_acao_social) {
		this.desc_acao_social = desc_acao_social;
	}
	
	
}

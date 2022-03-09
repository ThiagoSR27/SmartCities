package br.com.fiap.smartcities.domain;

import java.io.Serializable;
import java.util.Objects;

public class FinanciamentoId implements Serializable{
	
	private int id;
	private int parceiro;
	
	public FinanciamentoId(int financiamento, int parceiro) {
		super();
		this.id = financiamento;
		this.parceiro = parceiro;
	}

	public FinanciamentoId() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, parceiro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FinanciamentoId other = (FinanciamentoId) obj;
		return id == other.id && parceiro == other.parceiro;
	}
	
}

package br.com.fiap.smartcities.domain;

import java.io.Serializable;
import java.util.Objects;

public class ImplantacaoId implements Serializable{
	private int id;
	
	private int projeto;

	public ImplantacaoId(int id, int projeto) {
		super();
		this.id = id;
		this.projeto = projeto;
	}

	public ImplantacaoId() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, projeto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImplantacaoId other = (ImplantacaoId) obj;
		return id == other.id && projeto == other.projeto;
	}

	
}

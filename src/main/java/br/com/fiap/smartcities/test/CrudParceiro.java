package br.com.fiap.smartcities.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.Parceiro;

public class CrudParceiro {
	
		//Deve ser buildado primeiro a classe Cadastro com o persistence alterado para create
		//Apos a criaçao do banco apartir do cadastro altere o persistence para update
		//Foi criado dessa forma para que o codigo possa ser utilizado inumeras vezes
	
	public static void main(String[] args) {
		
		//Cria um Parceiro de teste,e caso ele ja esteja criado,
		//Altera o conteudo da tabela e a deleta mostrando no console, efetua rollback para manter a massa de teste no banco de dados.
		//Deve ser utilizada com update no persistence
		
		EntityManager em = Persistence.createEntityManagerFactory("smartcities").createEntityManager();
				
		Parceiro parceiro = em.find(Parceiro.class,2);
				
		if(parceiro != null) {
			System.out.println("ANTES - "+parceiro.getId()+" - " + parceiro.getNome_parceiro());
			parceiro.setNome_parceiro("Novo Parceiro");
			System.out.println("DEPOIS - "+parceiro.getId()+" - " + parceiro.getNome_parceiro());
			em.remove(parceiro);
			em.getTransaction().begin();
			em.getTransaction().rollback();
			
			}else {
			Parceiro parc1 = new Parceiro(0,"Parceiro",new GregorianCalendar(2021,Calendar.FEBRUARY,25),new GregorianCalendar(2022,Calendar.FEBRUARY,25));
			em.persist(parc1);
			em.getTransaction().begin();
			em.getTransaction().commit();
			em.close();
		}
	}
}

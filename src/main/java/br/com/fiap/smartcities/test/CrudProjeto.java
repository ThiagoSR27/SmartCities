package br.com.fiap.smartcities.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.Projeto;

public class CrudProjeto {
	
	//Deve ser buildado primeiro a classe Cadastro com o persistence alterado para create
	//Apos a criaçao do banco apartir do cadastro altere o persistence para update
	//Foi criado dessa forma para que o codigo possa ser utilizado inumeras vezes
	
	public static void main(String[] args) {
		
		//Cria um projeto de teste,e caso ele ja esteja criado,
		//Altera o conteudo da tabela e a deleta mostrando no console, efetua rollback para manter a massa de teste no banco de dados.
		
		EntityManager em = Persistence.createEntityManagerFactory("smartcities").createEntityManager();
		
		
		Projeto projeto = em.find(Projeto.class,3);
		
		if(projeto != null) {
			System.out.println("ANTES - "+projeto.getId()+" - " + projeto.getDesc_projeto()+" - "+ projeto.getNome_projeto());
			projeto.setNome_projeto("oNovoEu");
			projeto.setDesc_projeto("Novo Projeto");
			System.out.println("DEPOIS - "+projeto.getId()+" - " + projeto.getDesc_projeto()+" - "+ projeto.getNome_projeto());
			em.remove(projeto);
			em.getTransaction().begin();
			em.getTransaction().rollback();
			
			}else {
			Projeto proj1 = new Projeto(0,null,"Antigo","Projeto Antigo",new GregorianCalendar(2015,Calendar.JANUARY,10),new GregorianCalendar(2018,Calendar.JANUARY,22));
			em.persist(proj1);
			em.getTransaction().begin();
			em.getTransaction().commit();
			em.close();
		}
	}
}

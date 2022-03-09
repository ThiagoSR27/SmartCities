package br.com.fiap.smartcities.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.Colaborador;
import br.com.fiap.smartcities.domain.Contrato;
import br.com.fiap.smartcities.domain.Departamento;
import br.com.fiap.smartcities.domain.Estabelecimento;
import br.com.fiap.smartcities.domain.Financiamento;
import br.com.fiap.smartcities.domain.Implantacao;
import br.com.fiap.smartcities.domain.Parceiro;
import br.com.fiap.smartcities.domain.Projeto;
import br.com.fiap.smartcities.domain.Tipo;

public class Cadastro {
	public static void main(String[] args) {//Essa class é utilizada para gerar o banco de dados com as tabelas e minimamente uma massa de dados.
		// Necessario alterar o persistence para create
		EntityManager em = Persistence.createEntityManagerFactory("smartcities").createEntityManager();
		
		Tipo tipo1 = new Tipo(0,"educacao", "educacao para a cidadania");
		Tipo tipo2 = new Tipo(0,"meio ambiente", "recuperacao e preservacao ambiental");
				
		Projeto proj1 = new Projeto(0,tipo1,"espaço do saber","construcao de uma biblioteca comunitaria no bairro Majori",new GregorianCalendar(2015,Calendar.JANUARY,10),new GregorianCalendar(2018,Calendar.JANUARY,22));
		
		Projeto proj2 = new Projeto(0,tipo2,"semear","plantio de 1.000 mudas de arvores nativas no distrito de Santa Maria",new GregorianCalendar(2018,Calendar.JULY,15),new GregorianCalendar(2018,Calendar.AUGUST,15));
		
		Estabelecimento estab1 = new Estabelecimento(0,"London",new GregorianCalendar(2002,Calendar.SEPTEMBER,20));
		
		Departamento dep1 = new Departamento(0,"Financeiro");
		
		Colaborador colab1 = new Colaborador(0,"COLAB",new GregorianCalendar(2021,Calendar.FEBRUARY,10),"Rua Jundiapeba Av 10 Jardim Operopolis SP",10000,estab1,dep1);
		
		Contrato cont1 = new Contrato(0,"Voluntario","Voluntario","Fornecer ajuda necessaria as causas da empresa");
		
		Parceiro parc1 = new Parceiro(0,"OTAN",new GregorianCalendar(2021,Calendar.FEBRUARY,25),new GregorianCalendar(2022,Calendar.FEBRUARY,25));
		
		Financiamento fin1 = new Financiamento(0,parc1,estab1,"SFH",new GregorianCalendar(2021,Calendar.JANUARY,31),20000);
		
		Implantacao imp1 = new Implantacao(0,proj2,colab1,new GregorianCalendar(2021,Calendar.JUNE,2),new GregorianCalendar(2022,Calendar.JUNE,2));
		try{
		em.persist(fin1);
		em.persist(colab1);
		em.persist(proj2);
		em.persist(proj1);
		em.persist(cont1);
		em.persist(imp1);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		}catch(Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
	}
}

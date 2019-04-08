package com.hepta.mercado.test;

import org.junit.Test;

import com.hepta.mercado.persistence.HibernateUtil;

public class HibernateClass {
	
	@Test //Comamndo para criar as tabelas dentro do banco de dados
	public void TesteUpdate(){
		HibernateUtil.getEntityManager();
	}
}

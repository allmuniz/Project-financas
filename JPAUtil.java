package br.com.caelum.financas.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("financasPU");
	
	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}

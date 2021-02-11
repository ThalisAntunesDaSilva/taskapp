package br.com.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("TaskApp");

	public EntityManager getConnection() {
		return emf.createEntityManager();
	}

}

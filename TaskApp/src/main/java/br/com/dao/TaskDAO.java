package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.entidades.Task;
import br.com.jpautil.ConnectionFactory;

public class TaskDAO<T> {

	public void salvar(T entidade) {
		EntityManager entityManager = ConnectionFactory.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(entidade);
		entityTransaction.commit();
		entityManager.close();
		
	}

	public T merge(T entidade) {
		EntityManager entityManager = ConnectionFactory.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		T retorno = entityManager.merge(entidade);
		entityTransaction.commit();
		entityManager.close();

		return retorno;
	}

	@SuppressWarnings("unchecked")
	public List<Task> findAll() {
		@SuppressWarnings("static-access")
		EntityManager em = new ConnectionFactory().getEntityManager();
		List<Task> tasks = null;

		try {

			tasks = em.createQuery("from Task").getResultList();

		} catch (Exception e) {
			System.err.println(e);

		} finally {
			em.close();
		}

		return tasks;

	}

	public Task findById(Integer id) {
		@SuppressWarnings("static-access")
		EntityManager em = new ConnectionFactory().getEntityManager();
		Task task = null;

		try {
			task = em.find(Task.class, id);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return task;
	}

	public Task remove(Integer id) {
		@SuppressWarnings("static-access")
		EntityManager em = new ConnectionFactory().getEntityManager();
		Task task = null;
		try {
			task = em.find(Task.class, id);
			em.getTransaction().begin();
			em.remove(task);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return task;
	}

	public List<T> getListEntity(Class<Task> task) {
		EntityManager entityManager = ConnectionFactory.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		@SuppressWarnings("unchecked")
		List<T> retorno = entityManager.createQuery("from " + task.getName()).getResultList();
		entityTransaction.commit();
		entityManager.close();
		return retorno;
	}

}

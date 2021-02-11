package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.bean.Task;
import br.com.connection.ConnectionFactory;

public class TaskDAO {

	public Task save(Task task) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();

			if (task.getId() == null) {
				em.persist(task);
			} else {
				em.merge(task);
			}

			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return task;
	}

	public Task findById(Integer id) {

		EntityManager em = new ConnectionFactory().getConnection();
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

	@SuppressWarnings("unchecked")
	public List<Task> findAll() {
		EntityManager em = new ConnectionFactory().getConnection();
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

	public Task remove(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
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

}

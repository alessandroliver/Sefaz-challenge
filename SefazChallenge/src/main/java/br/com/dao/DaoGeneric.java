package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.jpautils.JPAUtil;

public class DaoGeneric<E> {

	public void save(E entity) {

		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.persist(entity);
		entityTransaction.commit();
		entityManager.close();
	}

	public E merge(E entity) {

		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		E r = entityManager.merge(entity);
		entityTransaction.commit();
		entityManager.close();

		return r;
	}

	public void deleteID(E entity) {

		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Object id = JPAUtil.getPrimaryKey(entity);
		entityManager.createQuery("delete from " + entity.getClass().getCanonicalName() + " where id= " + id)
				.executeUpdate();
		entityTransaction.commit();
		entityManager.close();
	}

	public List<E> getGenericList(Class<E> entity) {

		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		List<E> r = entityManager.createQuery("from " + entity.getName()).getResultList();

		entityTransaction.commit();
		entityManager.close();

		return r;
	}

}

package br.com.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.entities.UserEntity;
import br.com.jpautils.JPAUtil;
import br.com.sefaz.UserBean;

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

	public void deleteID(String id) {

		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		
		entityManager.createQuery("delete from " + "UserEntity" + " where id= " + id).executeUpdate();
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

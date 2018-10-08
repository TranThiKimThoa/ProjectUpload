package com.paracel.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.core.GenericTypeResolver;


public abstract class AbstractDao<T> {
	
	@PersistenceContext
	protected EntityManager entityManager;

	private final Class<T> type;
	
	@SuppressWarnings("unchecked")
	public AbstractDao() {
		type = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), AbstractDao.class);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public T save(T emp) {
		EntityManager em = getEntityManager();
		em.persist(emp);
		return emp;
	}

	
	public void delete(Object id) {
		EntityManager em = getEntityManager();
		T t = em.getReference(type, id);
		em.remove(t);
	}

	
	public T edit(T emp) {
		EntityManager em = getEntityManager();
		T t = em.merge(emp);
		return t;

	}

	public T find(Object id) {
		EntityManager em = getEntityManager();
		return (T) em.find(type, id);
	}

}

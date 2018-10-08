package com.paracel.dao;

public interface Dao<T> {
	public T save(T emp);

	public void delete(Object id);

	public T edit(T emp);

	public T find(Object id);
	
}

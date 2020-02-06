package org.eclipse.dao;

import java.util.List;

public interface Dao<T> {
	int save(T obj);

	void remove(T obj);

	T update(T obj);

	T findById(int id);

	List<T> getAll();
}

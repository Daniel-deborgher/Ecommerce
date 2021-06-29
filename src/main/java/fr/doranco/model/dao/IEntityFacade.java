package fr.doranco.model.dao;

import java.util.List;

public interface IEntityFacade<T> {

	
	T get(Class<T> entity, Integer id) throws Exception;
	List<T> getAll(Class<T> entity) throws Exception;
	void update(T entity) throws Exception;
	void remove(T entity) throws Exception;
}

package pl.javastart.dao;

import java.util.List;

import pl.javastart.model.Discovery;

public interface DiscoveryDAO extends GenericDAO<Discovery, Long>{
	List<Discovery>getAll();
}

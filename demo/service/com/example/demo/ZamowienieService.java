package com.example.demo;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public interface ZamowienieService{

	public Zamowienie findById(Long id);
	public List<Zamowienie> findAll();
	public Zamowienie save(Zamowienie Produkt);
	public void delete(long ID);
	public Zamowienie update(Long id,Zamowienie zam);

	// Named query with parameter
	Collection<Zamowienie> findAllAfterDate(String datazam);
	
	// @Query with parameter
	List<Zamowienie> findAllZamowienias(Sort sort);
	
	// Named query without parameter
	List<Zamowienie> findAllWynos();

	// Query methods (2)
	List<Zamowienie> findByDatazamGreaterThanEqualAndWynosIs (String datazam, boolean wynos);
	List<Zamowienie> findByDatazamAfterAndDatazamBeforeOrderByDatazamAsc(String start, String end);
}

package com.example.demo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Component
public class ZamowienieServiceImpl implements ZamowienieService{


	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ZamowienieRepository repository;
    
	@Transactional
	public Zamowienie findById(Long id) {
		return repository.findById(id).get();
	}

	@Transactional
	public List<Zamowienie> findAll() {
		return repository.findAll();
	}


	@Transactional
	public Zamowienie save(Zamowienie zam) {
		em.flush();
		return repository.save(zam);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Zamowienie> findAllAfterDate(String datazam) {
	      return (Collection<Zamowienie>) em.createNamedQuery("findAllAfterDate")
	                                      .setParameter("datazam", datazam)
	                                      .getResultList();
	}

//	public List<Produkt> findByLastname(String lastname, int page, int pageSize) {
//
//		TypedQuery query = em.createQuery("select c from Produkt c where c.lastname = ?1", Produkt.class);
//
//		query.setParameter(1, lastname);
//		query.setFirstResult(page * pageSize);
//		query.setMaxResults(pageSize);
//
//		return query.getResultList();
//	}

	@Override
	public void delete(long ID) {
		repository.deleteById(ID);
		
	}

	@Override
	public Zamowienie update(Long id, Zamowienie zam) {
		Zamowienie current = repository.findById(id).get();
		current.setdatazam(zam.getdatazam());
		current.setWynos(zam.getWynos());
		return repository.save(current);
	}

	@Override
	public List<Zamowienie> findAllZamowienias(Sort sort) {
		
		return repository.findAllZamowienias(sort);
	}

	@Override
	public List<Zamowienie> findAllWynos() {
	
		return repository.findAllWynos();
	}

	@Override
	public List<Zamowienie> findByDatazamGreaterThanEqualAndWynosIs(String datazam, boolean wynos) {
		
		return repository.findByDatazamAfterAndWynosIs(datazam, wynos);
	}

	@Override
	public List<Zamowienie> findByDatazamAfterAndDatazamBeforeOrderByDatazamAsc(String start, String end) {
		return repository.findByDatazamAfterAndDatazamBeforeOrderByDatazamAsc(start, end);
	}
}

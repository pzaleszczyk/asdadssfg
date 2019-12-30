package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Component
public class ZamProdServiceImpl implements ZamProdService{


	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ZamProdRepository repository;


    
	@Transactional
	public Zamprod findByPId(Long id) {
		//TO DO
		return repository.findById(id).get();
	}
	
	@Transactional
	public Zamprod findByZId(Long id) {
		//TO DO
		return repository.findById(id).get();
	}

	@Transactional
	public List<Zamprod> findAll() {
		return repository.findAll();
	}
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
		
	}

	@Transactional
	public Zamprod save(Zamprod zam) {
		em.flush();
		return repository.save(zam);
		
	}

	public List<Produkt> findByLastname(String lastname, int page, int pageSize) {

		TypedQuery query = em.createQuery("select c from Produkt c where c.lastname = ?1", Produkt.class);

		query.setParameter(1, lastname);
		query.setFirstResult(page * pageSize);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	@Override
	public List<IloscProduktow> getIloscZamowionychProduktow() {
		
		return repository.getIloscZamowionychProduktow();
	}

	@Override
	public List<Rachunek> getRachunek() {

		return repository.getRachunek();
	}
}

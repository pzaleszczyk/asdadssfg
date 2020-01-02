package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	public List<Zamprod> findByZId(Zamowienie a, int pageSize) {
		
		TypedQuery<Zamprod> query = em.createQuery(
				" select zp from Zamprod zp " + 
				" where zp.zam = ?1",Zamprod.class);

		query.setParameter(1, a);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}
	
	@Transactional
	public List<Zamprod> findByPId(Produkt a, int pageSize) {
		
		TypedQuery<Zamprod> query = em.createQuery(
				" select zp from Zamprod zp " + 
				" where zp.prod = ?1",Zamprod.class);

		query.setParameter(1, a);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	@Transactional
	public List<Zamprod> findAll() {
		return repository.findAll();
	}
	@Transactional
	public void delete(long id) {
		repository.deleteById(id);
		
	}

	@Transactional
	public Zamprod save(Zamprod zam) {
		return repository.save(zam);
		
	}

	@Override
	public List<IloscProduktow> getIloscZamowionychProduktow() {
		
		return repository.getIloscZamowionychProduktow();
	}

	@Override
	public List<Rachunek> getRachunek() {

		return repository.getRachunek();
	}

	@Transactional
	public Zamprod update(long id, Zamprod zamprod) {
		zamprod.setId(id);
		return repository.save(zamprod);
	}

}

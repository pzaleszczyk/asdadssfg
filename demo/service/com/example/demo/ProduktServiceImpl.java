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
import org.springframework.transaction.interceptor.TransactionAspectSupport;


@Component
public class ProduktServiceImpl implements ProduktService{


	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ProduktRepository repository;
    
	@Transactional
	public Produkt findById(Long id) {
		return repository.findById(id).get();
	}

	//(c-R-ud)
	@Transactional
	public List<Produkt> findAll() {
		return repository.findAll();
	}


	//(-C-rud)
	@Transactional
	public Produkt save(Produkt Produkt) {
		//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		return repository.save(Produkt);
	}
	//(cr-U-d)
	@Transactional
	public Produkt update(Long id,Produkt Produkt) {
		Produkt current = repository.findById(id).get();
		current.setNazwa(Produkt.getNazwa());
		current.setVege(Produkt.getVege());
		current.setCena(Produkt.getCena());
		return repository.save(current);
	}

	//(cru-D-)
	@Transactional
	public void delete(long ID) {
			repository.deleteById(ID);
	}

//
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
	public Collection<Produkt> findAllBelowPrice(double cena) {
	      return (Collection<Produkt>) em.createNamedQuery("findAllBelowPrice")
	                                      .setParameter("cena", cena)
	                                      .getResultList();
	}
	@Override
	public List<Produkt> findAllVege() {
	      return repository.findAllVege();
	}

	@Override
	public List<Produkt> findAllProdukts(Sort sort) {
		return repository.findAllProdukts(sort);
	}

//	@Override
//	public List<Produkt> findByNazwaContaining(String nazwa) {
//		return repository.findByNazwaContaining(nazwa);
//	}

	@Override
	public List<Produkt> findByCenaGreaterThanEqualAndVegeIs (double cena, boolean vege){
		return repository.findByCenaGreaterThanEqualAndVegeIs(cena, vege);
	}

	@Override
	public List<Produkt> findByNazwaContainingAndVegeIsFalseAndCenaNotNull(String nazwa) {
		
		return repository.findByNazwaContainingAndVegeIsFalseAndCenaNotNull(nazwa);
	}
}

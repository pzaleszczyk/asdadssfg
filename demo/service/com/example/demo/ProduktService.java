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
public interface ProduktService{
	
	public Produkt findById(Long id);
	public List<Produkt> findAll();
	public Produkt save(Produkt Produkt);
	public void delete(long ID);
	public Produkt update(Long id,Produkt Produkt);
	
	// Named query with parameter
	Collection<Produkt> findAllBelowPrice(double price);
	// Named query without parameter
	List<Produkt> findAllVege();
	// @Query with parameter
	List<Produkt> findAllProdukts(Sort sort);
	List<Produkt> findByNazwaContaining	(String nazwa);
	// Query methods (1)
	List<Produkt> findByCenaGreaterThanEqualAndVegeIs (double cena, boolean vege);
	List<Produkt> findByNazwaContainingAndVegeFalseAndCenaNotNull(String nazwa);
	
	
}

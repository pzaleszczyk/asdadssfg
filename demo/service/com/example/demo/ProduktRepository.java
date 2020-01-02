package com.example.demo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProduktRepository extends JpaRepository<Produkt, Long>{
	//(1) @Query 
	@Query(value = "SELECT u FROM Produkt u")
	List<Produkt> findAllProdukts(Sort sort);

	//(1) Query methods
	List<Produkt> findByNazwaContaining	(String nazwa);
	List<Produkt> findByCenaGreaterThanEqualAndVegeIs (double cena, boolean vege);
	List<Produkt> findByNazwaContainingAndVegeIsFalseAndCenaNotNull(String nazwa);
	
	
	//(1) Named query without parameter
	List<Produkt> findAllVege();

}

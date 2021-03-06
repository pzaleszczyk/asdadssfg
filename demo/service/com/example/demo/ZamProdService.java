package com.example.demo;
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
public interface ZamProdService{

	//public Zamprod findByZId(Long id);
	//public Zamprod findByPId(Long id);
	public void delete(long l);
	public List<Zamprod> findAll();
	public Zamprod save(Zamprod zamprod);
	public Zamprod update(long l,Zamprod zamprod);
	
	public List<Zamprod> findByZId(Zamowienie a,int pageSize);
	public List<Zamprod> findByPId(Produkt a,int pageSize);
	
	List<IloscProduktow> getIloscZamowionychProduktow();
	List<Rachunek> getRachunek();
	
	// @Query
	//List<Produkt> findAllProdukts(Sort sort);
	// Query methods
	//List<Produkt> findByNazwaContaining	(String nazwa);
	// @Query
	//List<Produkt> findAllProdukts(Sort sort);
	// Query methods
	//List<Produkt> findByNazwaContaining	(String nazwa);
}

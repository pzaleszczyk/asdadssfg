package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig.TransactionMode;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Sql("classpath:./query.sql")
class DemoApplicationTests {

	
	@Autowired
	ProduktService repo;
	
	@Autowired
	ZamProdService zprepo;
	
	@Autowired
	ZamowienieService zrepo;

	@Test
	void contextLoads() {
		
	}

	
	@Test
	void correctFindZamprodByZam() {
		Zamowienie a = zrepo.findById(3L);
		for(Object b : zprepo.findByZId(a, 10)) {
			System.out.println(b);
		};
	}
	@Test
	void crudZamprodTest() {
		zprepo.findAll();
		Zamowienie zam = new Zamowienie("1900-10-10",true);
		zrepo.save(zam);
		Produkt pro = new Produkt("nazwa", 100.50, true);
		repo.save(pro);
		Zamprod zamprod = new Zamprod(pro,zam,7);
		zprepo.save(zamprod);
		Zamprod zamprodnew = zprepo.findByPId(pro, 10).get(0);
		Zamprod updated = new Zamprod(pro,zam,10);
		zprepo.update(zamprodnew.getId(), updated);
		
		zprepo.delete(zamprodnew.getId());
	}
	
	@Test
	void crudZamowienieTest() {
		Zamowienie zam = new Zamowienie("1900-10-10",true);
		zrepo.save(zam);
		Zamowienie zamid = null;
		for(Zamowienie a : zrepo.findAll()) {
			zamid = a;
		};
		Zamowienie updated = new Zamowienie("1990-10-20",false);
		zrepo.update(zamid.getId(), updated);
		zrepo.delete(zamid.getId());
	}
	
	@Test
	void crudProduktTest() {
		Produkt pro = new Produkt("nazwa", 100.50, true);
		repo.save(pro);
		Produkt proid = null;
		for(Produkt a : repo.findAll()) {
			proid = a;
		};
		Produkt updated = new Produkt("nazwa1", 1004.50, false);
		repo.update(proid.getId(), updated);
		repo.delete(proid.getId());
	}
	
	@Test
	void correctFindZamprodByProd() {
		Produkt a = repo.findById(3L);
		for(Object b : zprepo.findByPId(a, 10)) {
			System.out.println(b);
		};
	}
	
	@Test
	void getRachunek() {
		for(Rachunek a : zprepo.getRachunek()) {
			System.out.println(a);
		}
	}
	
	@Test
	void getIloscZamowionych() {
		for(IloscProduktow a : zprepo.getIloscZamowionychProduktow()) {
			System.out.println(a);
		}
	}

	
	@Test
	public void allAfterAndWynosTest() {

		for(Zamowienie a : zrepo.findByDatazamGreaterThanEqualAndWynosIs("1999-10-09", false)){
			System.out.println(">= and false: " +a);
		}

	}
	@Test
	public void allAfterTest() {
		
		for(Zamowienie a : zrepo.findAllAfterDate("1999-10-12")){
			System.out.println("after: " +a);
		}

	}
	@Test
	public void allZamowieniasTest() {
	
		for(Zamowienie a : zrepo.findAllZamowienias(JpaSort.unsafe("wynos"))){
			System.out.println("sort by wynos: " +a);
		}
	}
	@Test
	public void allZamowieniasBetween() {
		for(Zamowienie a : zrepo.findByDatazamAfterAndDatazamBeforeOrderByDatazamAsc("1900-10-10", "2003-10-10")) {
			System.out.println("between: " +a);
		}
	}
	
	@Test
	public void allWynosTest() {
		
		for(Zamowienie a : zrepo.findAllWynos()){
			System.out.println("all true: " +a);
		}
		
	}
	
	@Test
	public void whenFindingCustomerById_thenCorrect() {
		//System.out.println("Save");
		//repo.save(new Produkt("Chleb",12.25,true));
		//repo.save(new Produkt("Lmao",12.25,true));
		repo.save(new Produkt("CrashTestNew",4.25,false));
		
//		for(Produkt a : repo.findByNazwaContaining("ma")){
//			System.out.println("A: " +a);
//		}
		for(Produkt a : repo.findAllProdukts(JpaSort.unsafe("LENGTH(nazwa)"))){
			System.out.println("B: "+a);
		}
		for(Produkt a : repo.findAllBelowPrice(10.0)) {
			System.out.println("C: "+a);
		}
		for(Produkt a : repo.findAllVege()) {
			System.out.println("D: "+a);
		}
		for(Produkt a : repo.findByCenaGreaterThanEqualAndVegeIs(5.0,true)) {
			System.out.println("E: "+a);
		}
		for(Produkt a : repo.findByNazwaContainingAndVegeIsFalseAndCenaNotNull("MALY")) {
			System.out.println("F: "+a);
		}
		
		//repo.delete(1L);
		//assertThat(repo.findById(1L)).isInstanceOf(Optional.class);
		//JpaSort.unsafe("LENGTH(name)","afsddfas");
	}

}

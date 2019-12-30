package com.example.demo;

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

	
//	@Test
//	public void allAfterAndWynosTest() {
//
//		for(Zamowienie a : zrepo.findByDatazamGreaterThanEqualAndWynosIs("1999-10-09", false)){
//			System.out.println(">= and false: " +a);
//		}
//
//	}
//	@Test
//	public void allAfterTest() {
//		
//		for(Zamowienie a : zrepo.findAllAfterDate("1999-10-12")){
//			System.out.println("after: " +a);
//		}
//
//	}
//	@Test
//	public void allZamowieniasTest() {
//	
//		for(Zamowienie a : zrepo.findAllZamowienias(JpaSort.unsafe("wynos"))){
//			System.out.println("sort by wynos: " +a);
//		}
//	}
//	@Test
//	public void allWynosTest() {
//		
//		for(Zamowienie a : zrepo.findAllWynos()){
//			System.out.println("all true: " +a);
//		}
//		
//	}
//	
//	
//	public void whenFindingCustomerById_thenCorrect() {
//		System.out.println("Save");
//		//repo.save(new Produkt("Chleb",12.25,true));
//		//repo.save(new Produkt("Lmao",12.25,true));
//		repo.save(new Produkt("CrashTestNew",4.25,false));
//		
////		for(Produkt a : repo.findByNazwaContaining("ma")){
////			System.out.println("A: " +a);
////		}
////		for(Produkt a : repo.findAllProdukts(JpaSort.unsafe("LENGTH(nazwa)"))){
////			System.out.println("B: "+a);
////		}
////		for(Produkt a : repo.findAllBelowPrice(10.0)) {
////			System.out.println("C: "+a);
////		}
////		for(Produkt a : repo.findAllVege()) {
////			System.out.println("D: "+a);
////		}
////		for(Produkt a : repo.findByCenaGreaterThanEqualAndVegeIs(5.0,true)) {
////			System.out.println("E: "+a);
////		}
//		
//		//repo.delete(1L);
//		//assertThat(repo.findById(1L)).isInstanceOf(Optional.class);
//		//JpaSort.unsafe("LENGTH(name)","afsddfas");
//	}

}

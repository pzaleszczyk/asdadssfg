package com.example.demo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ZamProdRepository extends JpaRepository<Zamprod, Long>{


//	List<Produkt> findByNazwaContaining	(String nazwa);
//	List<Zamprod> findByIloscGreaterThanEqual (double cena, boolean vege);
	
	//@Query x2
	//Rachunek dla zamowienia.
	@Query(value	=" SELECT new com.example.demo.Rachunek(z.id as id, sum(p.cena*zp.ilosc)) "
					+" FROM Zamowienie as z, Produkt as p, Zamprod as zp "
					+" WHERE p.id = zp.prod AND z.id = zp.zam "
					+" GROUP BY z.id ")
	List<Rachunek> getRachunek();

	//Liczba zamowionych produktow
	@Query(value 	= "SELECT new com.example.demo.IloscProduktow(sum(zp.ilosc) as suma, p.nazwa) "
					+ "FROM Produkt p, Zamowienie z, Zamprod zp"
					+ " WHERE zp.zam = z.id AND zp.prod = p.id"
					+ " GROUP BY p.nazwa")
	List<IloscProduktow> getIloscZamowionychProduktow();

}

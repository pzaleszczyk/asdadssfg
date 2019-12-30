package com.example.demo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ZamowienieRepository extends JpaRepository<Zamowienie, Long>{
	// Named query without parameter
	List<Zamowienie> findAllWynos();
	
	//(1) @Query 
	@Query(value = "SELECT u FROM Zamowienie u")
	List<Zamowienie> findAllZamowienias(Sort sort);
	
	//(2) Query methods
	List<Zamowienie> findByDatazamAfterAndWynosIs (String datazam, boolean wynos);
	List<Zamowienie> findByDatazamAfterAndDatazamBeforeOrderByDatazamAsc(String start, String end);
}

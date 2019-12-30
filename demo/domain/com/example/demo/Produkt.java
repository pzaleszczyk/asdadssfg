package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Produkt")
@NamedQueries({
	//(1) named query with parameter
	@NamedQuery(name = "findAllBelowPrice",
	query = "SELECT c FROM Produkt c WHERE c.cena > :cena ORDER BY c.nazwa DESC"),
	//(2) named query without parameter
	@NamedQuery(name = "Produkt.findAllVege",
	query = "SELECT c FROM Produkt c WHERE vege = true ORDER BY c.nazwa DESC"),
})
public class Produkt {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
	Long id;
	@Column(name = "nazwa")
	String nazwa;
	@Column(name = "cena")
	Double cena;
	@Column(name = "vege")
	Boolean vege;
	
//	@OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            mappedBy = "Produkt")
//    private Set<Zamowienie> zamowienia = new HashSet<>();
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "produkt_id") // we need to duplicate the physical information
    private Set<Zamprod> zamowione;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	
	public Double getCena() {
		return cena;
	}
	public void setCena(Double cena) {
		this.cena = cena;
	}
	
	public Boolean getVege() {
		return vege;
	}
	public void setVege(Boolean vege) {
		this.vege = vege;
	}
	@Override
	public String toString() {
		return "Produkt [id=" + id + ", nazwa=" + nazwa + ", cena=" + cena + ", vege=" + vege + "]";
	}
	public Produkt(Long id, String nazwa, Double cena, Boolean vege) {
		super();
		this.id = id;
		this.nazwa = nazwa;
		this.cena = cena;
		this.vege = vege;
	}
	public Produkt(String nazwa, Double cena, Boolean vege) {
		super();
		this.nazwa = nazwa;
		this.cena = cena;
		this.vege = vege;
	}
	public Produkt() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}

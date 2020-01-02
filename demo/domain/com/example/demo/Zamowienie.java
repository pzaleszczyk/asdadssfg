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
@Table(name = "Zamowienie")
@NamedQueries({
	//(1) named query with parameter
	@NamedQuery(name = "findAllAfterDate",
	query = "SELECT c FROM Zamowienie c WHERE c.datazam > :datazam ORDER BY c.id DESC"),
	//(2) named query without parameter
	@NamedQuery(name = "Zamowienie.findAllWynos",
	query = "SELECT c FROM Zamowienie c WHERE wynos = true ORDER BY c.id DESC"),
})
public class Zamowienie {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
	Long id;
	@Column(name = "datazam")
	String datazam;
	@Column(name = "wynos")
	Boolean wynos;
	
//	@OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            mappedBy = "Zamowienie")
//    private Set<Produkt> produkty = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "zam") // we need to duplicate the physical information
    private Set<Zamprod> zamowione;
	
	public Set<Zamprod> getChildren() {
		return zamowione;
	}
	public void setChildren(Set<Zamprod> aSet) {
	    //this.sonEntities = aSet; //This will override the set that Hibernate is tracking.
	    this.zamowione.clear();
	    if (aSet != null) {
	        this.zamowione.addAll(aSet);
	    }
	}
	
	public Zamowienie(Long id, String datazam, Boolean wynos) {
		super();
		this.id = id;
		this.datazam = datazam;
		this.wynos = wynos;
	}


	@Override
	public String toString() {
		return "Zamowienie [id=" + id + ", datazam=" + datazam + ", wynos=" + wynos + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getdatazam() {
		return datazam;
	}


	public void setdatazam(String datazam) {
		this.datazam = datazam;
	}


	public Boolean getWynos() {
		return wynos;
	}


	public void setWynos(Boolean wynos) {
		this.wynos = wynos;
	}


	public Zamowienie() {
		// TODO Auto-generated constructor stub
	}


	public Zamowienie(String datazam, Boolean wynos) {
		super();
		this.datazam = datazam;
		this.wynos = wynos;
	}


	public void update(Zamowienie nowy) {
		this.datazam = nowy.getdatazam();
		this.wynos = nowy.getWynos();
	}
	
	
	
}

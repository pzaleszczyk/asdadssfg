package com.example.demo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Zamprod")
public class Zamprod {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
	long id;

	//	@ManyToOne(fetch = FetchType.LAZY)
	//	@JoinColumn(name = "prod", nullable = false)
	//	private Produkt prod;
	//
	//	@ManyToOne(fetch = FetchType.LAZY)
	//	@JoinColumn(name = "zam", nullable = false)
	//	private Zamowienie zam;

	@ManyToOne
	@JoinColumn(name = "prod")
	private Produkt prod;

	@ManyToOne
	@JoinColumn(name = "zam")
	private Zamowienie zam;

	@Column(name = "ilosc")
	int ilosc;

	public Produkt getProd() {
		return prod;
	}

	public void setProd(Produkt prod) {
		this.prod = prod;
	}

	public Zamowienie getZam() {
		return zam;
	}

	public void setZam(Zamowienie zam) {
		this.zam = zam;
	}

	public int getIlosc() {
		return ilosc;
	}

	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}

	@Override
	public String toString() {
		return "ZamProd [prod=" + prod + ", zam=" + zam + ", ilosc=" + ilosc + "]";
	}

	public Zamprod(Produkt prod, Zamowienie zam, int ilosc) {
		super();
		this.prod = prod;
		this.zam = zam;
		this.ilosc = ilosc;
	}

	public Zamprod() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}




}

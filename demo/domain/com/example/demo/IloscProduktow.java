package com.example.demo;

public class IloscProduktow {
	private long ilosc;
	private String nazwa;
	public IloscProduktow(long ilosc, String nazwa) {
		super();
		this.ilosc = ilosc;
		this.nazwa = nazwa;
	}
	@Override
	public String toString() {
		return "IloscProduktow [ilosc=" + ilosc + ", nazwa=" + nazwa + "]";
	}
	
}

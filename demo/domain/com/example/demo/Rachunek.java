package com.example.demo;

public class Rachunek {
	private long id;
	private double suma;
	public Rachunek(long id, double suma) {
		super();
		this.id = id;
		this.suma = suma;
	}
	@Override
	public String toString() {
		return "Rachunek [id=" + id + ", suma=" + suma + "]";
	}
	
}
package com.example.library.utils.paginator;

public class PageItem {

	// Representa una página

	private int numero; // número de página
	private boolean actual; // si es la página actual
	
	// constructor
	public PageItem(int numero, boolean actual) {
		super();
		this.numero = numero;
		this.actual = actual;
	}
	
	// getters
	public int getNumero() {
		return numero;
	}

	public boolean isActual() {
		return actual;
	}
	
}

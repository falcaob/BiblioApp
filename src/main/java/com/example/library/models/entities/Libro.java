package com.example.library.models.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "libros")
public class Libro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min = 3, max = 35)
	private String titulo;
	
	@NotEmpty
	@Size(min = 3, max = 25)
	private String autor;
	
	@NotEmpty
	@Size(min = 3, max = 25)
	private Long ejemplares;
	
	@NotEmpty
	@Size(min = 3, max = 15)
	private String genero;
	
	
	// getters y setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Long getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(Long ejemplares) {
		this.ejemplares = ejemplares;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

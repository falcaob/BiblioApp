package com.example.library.models.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "libros")
@Data
public class Libro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min = 3, max = 50)
	private String titulo;
	
	@NotEmpty
	@Size(min = 3, max = 50)
	private String autor;
	
	@NotNull
	@Min(value = 0)
	@Max(value = 900_000)
	private Long ejemplares;
	
	@NotEmpty
	@Size(min = 3, max = 50)
	private String genero;
	
	@NotNull
	@Min(value = 0)
	@Max(value = 100_000)
	private Double precio;
	

}

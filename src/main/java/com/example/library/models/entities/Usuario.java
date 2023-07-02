package com.example.library.models.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min = 3, max = 50)
	private String nombre;
	
	@NotEmpty
	@Size(min = 3, max = 50)
	private String apellidos;
	
	@NotEmpty
	@Size(min = 3, max = 50)
	private String usuario;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotNull
	private boolean prestamos;

}

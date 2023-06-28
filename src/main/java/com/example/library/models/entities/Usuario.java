package com.example.library.models.entities;

import java.io.Serializable;
import java.time.LocalDate;
//import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
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
	private String apellido;
	
	@NotEmpty
	@Email
	private String email;
	
	@Column(name = "create_at")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate fechaNacimiento;

}

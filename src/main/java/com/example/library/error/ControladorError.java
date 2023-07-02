package com.example.library.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Controller especial para capturar excepciones
@ControllerAdvice
@RequestMapping("error")
public class ControladorError {
	
	@GetMapping("/error")
	public String m1() {
		
		return "";		
	}
	
	@GetMapping("/error500")
	public String m2 () {
		
		return "noexiste";
				
	}
	
	@GetMapping("/division-0")
	public String m3() {
		int x = 1/0;
		return "noexiste";		
	}

	
	@GetMapping("/null-pointer")
	public String m4() {
		String s = null;
		s.length();
		return "noexiste";		
	}
}

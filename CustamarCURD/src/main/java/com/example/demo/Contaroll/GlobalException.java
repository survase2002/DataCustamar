package com.example.demo.Contaroll;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Exception.InvaliMobileno;
import com.example.demo.Exception.InvalidName;
import com.example.demo.Exception.Invalidid;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(InvaliMobileno.class)
	public ResponseEntity<?> InvalidMobileno(InvaliMobileno e){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT)
				.body(e.getMessage());
	}
	@ExceptionHandler(InvalidName.class)
	public ResponseEntity<?>InvalidName(InvalidName n) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT)
				.body(n.getMessage());
		
	}
	@ExceptionHandler(Invalidid.class)
	public ResponseEntity<?>Invalidid(Invalidid d){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT)
				.body(d.getMessage());
	}
}
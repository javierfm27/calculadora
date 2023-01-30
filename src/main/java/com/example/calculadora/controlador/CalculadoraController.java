package com.example.calculadora.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.calculadora.servicios.CalculadoraServiceImpl;

@RestController
@RequestMapping("/api")
public class CalculadoraController 
{
	@Autowired
	private CalculadoraServiceImpl calculService;
	
	@PostMapping(value = "calcula")
	public  ResponseEntity<Double> calculaOperacion(
			@RequestParam(name = "num1") String num1,
			@RequestParam(name = "num2") String num2,
			@RequestParam(name = "operacion") String operacion)
	{
		double resultado = calculService.calcularOperacion(num1, num2, operacion);
		
		return new ResponseEntity<Double>(resultado, HttpStatus.OK);
	}
}

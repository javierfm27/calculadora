package com.example.calculadora;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.calculadora.servicios.CalculadoraServiceImpl;

class CalculadoraServiceTest 
{

	private CalculadoraServiceImpl calcuService = new CalculadoraServiceImpl();
	
	
	@Test
	void when_num_is_wrong()
	{
		assertThrows(NumberFormatException.class, () -> {
			calcuService.calcularOperacion("uno", "dos", "+");
		});
	}
	
	@Test
	void when_num2_is_wrong()
	{
		assertThrows(NumberFormatException.class, () -> {
			calcuService.calcularOperacion("uno", "dos", "+");
		});
	}
	
	@Test
	void when_operation_is_mult()
	{
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, 
					() -> {calcuService.calcularOperacion("1", "2", "*");});
	
		assertEquals("Operacion mas adelante: *", ex.getMessage());
	}
	
	@Test
	void when_operation_is_div()
	{
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, 
					() -> {calcuService.calcularOperacion("2", "1", "/");});
	
		assertEquals("Operacion mas adelante: /", ex.getMessage());
	}

	@Test
	void when_operation_is_wrong()
	{
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, 
				() -> {calcuService.calcularOperacion("2", "1", "testOpMAL");});

		assertEquals("Unexpected value: testOpMAL", ex.getMessage());	
	}
	
	@Test
	void when_sum_is_correct_service()
	{
		
		assertEquals(3.0, calcuService.calcularOperacion("1", "2", "+"), 0.0);
	}
	
	@Test
	void when_sub_is_correct_service()
	{
		
		assertEquals(1.0, calcuService.calcularOperacion("2", "1", "-"), 0.0);
	}

}

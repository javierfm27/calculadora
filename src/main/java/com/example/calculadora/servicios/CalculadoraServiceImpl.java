package com.example.calculadora.servicios;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraServiceImpl implements CalculadoraService 
{
	Log log = LogFactory.getLog(CalculadoraServiceImpl.class);
	
	@Override
	public double calcularOperacion(String num1, String num2, String operacion) 
	{
		Integer op1 = Integer.parseInt(num1);
		Integer op2 = Integer.parseInt(num2);
		double resultado = 0.0;
		
		switch (operacion) 
		{
			case "+": {
				resultado = op1 + op2;
				break;
			}
			case "-": {
				resultado = op1 - op2;
				break;
			}
			case "*": 
			case "/": {
				throw new IllegalArgumentException("Operacion mas adelante: " + operacion);
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + operacion);
		}
		
		return resultado;
	}

}

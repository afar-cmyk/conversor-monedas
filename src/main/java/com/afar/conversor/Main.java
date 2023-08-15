package com.afar.conversor;
import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hola mundo");
		
		Convertidor prueba = new Convertidor ("usd", 1, "cop");
		
		System.out.println(2 * 0.000247);
		
		 double resultado = 2 * 0.000247;
	        
	        DecimalFormat df = new DecimalFormat("0.000000");
	        System.out.println(df.format(resultado));
	}

}

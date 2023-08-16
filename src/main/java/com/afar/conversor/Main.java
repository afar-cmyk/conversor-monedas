package com.afar.conversor;


public class Main {

	public static void main(String[] args) {
		
		// Convertidor prueba = new Convertidor ("usd", 1, "cop");
		
		Divisa prueba = new Divisa();
		
		System.out.println(prueba.obtenerPropiedadesDivisa("cop", "divisa"));
		//System.out.println(prueba.getPrueba1());
		//System.out.println(prueba.getPrueba2());
	}

}

//import java.text.DecimalFormat;
//double resultado = 2 * 0.000247;
//   
//DecimalFormat df = new DecimalFormat("0.000000");
//System.out.println(df.format(resultado));

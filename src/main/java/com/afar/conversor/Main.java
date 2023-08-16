package com.afar.conversor;

public class Main {

	public static void main(String[] args) {
		
		Divisa prueba = new Divisa();
		
		System.out.println(prueba.obtenerPropiedadesDivisa("cop", "nombreDivisa"));
		
		Convertidor prueba2 = new Convertidor();
		
		System.out.println("YEN A COP:");
		System.out.println(prueba2.convertir(1000, "jpy", "cop"));
		System.out.println("YEN A COP FORMATEADO:");
		prueba2.resultadoFormateado();
		
		System.out.println("");
		
		System.out.println("COP A YEN:");
		System.out.println(prueba2.convertir(100000, "cop", "jpy"));
		System.out.println("COP A YEN FORMATEADO:");
		prueba2.resultadoFormateado();
		
		System.out.println("");
		
		System.out.println("COP A USD:");
		System.out.println(prueba2.convertir(100000, "cop", "usd"));
		System.out.println("COP A USD FORMATEADO:");
		prueba2.resultadoFormateado();

	}

}

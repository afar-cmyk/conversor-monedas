package com.afar.conversor.logica;

public class Convertidor {
	private static double valorFinal;
	
	static Divisa divisa = new Divisa();
	
	private static double obtenerTasaDivisa(String codigoDivisa) {
		double tasaDivisa;
		tasaDivisa = Double.parseDouble(divisa.obtenerPropiedadesDivisa(codigoDivisa, "valor"));
		return tasaDivisa;
	}
	
	private static double convertirUSD(double valorIngresado, String codigoDivisa) {
		double valorFinalUSD;
		valorFinalUSD = valorIngresado * obtenerTasaDivisa(codigoDivisa);		
		return valorFinalUSD;
	}
	
	public static double convertir(double valorIngresado, String codigoDivisaBase, String codigoDivisaFinal) {
	    if (valorIngresado == 0) {
	        return valorIngresado;
	    } else {
	        valorFinal = (convertirUSD(valorIngresado, codigoDivisaBase)) / obtenerTasaDivisa(codigoDivisaFinal);
	        return valorFinal;
	    }
	}	
}

package com.afar.conversor.logica;

public class Convertidor {

	private double valorFinal;
	
	Divisa divisa = new Divisa();
	
	private double obtenerTasaDivisa(String codigoDivisa) {
		double tasaDivisa;
		tasaDivisa = Double.parseDouble(divisa.obtenerPropiedadesDivisa(codigoDivisa, "valor"));
		return tasaDivisa;
	}
	
	private double convertirUSD(double valorIngresado, String codigoDivisa) {
		double valorFinalUSD;
		valorFinalUSD = valorIngresado * obtenerTasaDivisa(codigoDivisa);		
		return valorFinalUSD;
	}
	
	public double convertir(double valorIngresado, String codigoDivisaBase, String codigoDivisaFinal) {
		valorFinal = (convertirUSD(valorIngresado, codigoDivisaBase)) / obtenerTasaDivisa(codigoDivisaFinal);
		return valorFinal;
	}
	
}

package com.afar.conversor.logica;

import java.text.DecimalFormat;

public class Convertidor {

	private double valorFinal;
	
	Divisa divisa = new Divisa();
	DecimalFormat df = new DecimalFormat("0.00");
	
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
	
	public void resultadoFormateado() {
		System.out.println(df.format(valorFinal));
	}
	
}

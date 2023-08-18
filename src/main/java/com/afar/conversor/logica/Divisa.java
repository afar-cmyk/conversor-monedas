package com.afar.conversor.logica;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Divisa {
	
	Properties listaDivisas = new Properties();
	
	public Divisa() {
		cargarListaDivisas();
	}
	
	public void cargarListaDivisas() {
		try {
			FileInputStream entrada = new FileInputStream("./src/main/divisas/listaDivisas.properties");
			listaDivisas.load(entrada);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String obtenerPropiedadesDivisa(String codigoDivisa, String propiedadDivisa) {
		if (comprobarCodigoDivisa(codigoDivisa) && comprobarPropiedadDivisa(propiedadDivisa)) {
			return listaDivisas.getProperty(codigoDivisa + "." + propiedadDivisa);
		} else if (!comprobarCodigoDivisa(codigoDivisa)) {
			return "Error! Codigo de divisa erroneo";
		} else {
			return "Error! Propiedad de divisa erroneo";
		}
	}
	
	private boolean comprobarCodigoDivisa(String codigoDivisa) { 
		return ((listaDivisas.getProperty(codigoDivisa + ".nombreDivisa") != null ));
	}
	
	private boolean comprobarPropiedadDivisa(String codigoDivisa) { 
		return ((listaDivisas.getProperty("cop." + codigoDivisa) != null ));
	}
	
	public Properties getPrueba2() {
		return listaDivisas;
	}
	
}

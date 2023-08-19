package com.afar.conversor.logica;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

public class ListarDivisas {
	private static final String rutaArchivo = "./src/main/divisas/listaDivisas.properties";
	
    private static Properties cargarArchivoProperties(String rutaArchivo) {
        try (FileInputStream fileInputStream = new FileInputStream(rutaArchivo);
             InputStreamReader reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8)) {
            Properties properties = new Properties();
            properties.load(reader);
            return properties;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String[] divisasDisponibles() {
        Set<String> clavesUnicas = new TreeSet<>();

        for (String key : cargarArchivoProperties(rutaArchivo).stringPropertyNames()) {
            String[] parts = key.split("\\.");
            
            if (parts.length == 2) {
                clavesUnicas.add(parts[0]);
            }
        }
        
        return clavesUnicas.toArray(new String[0]);
    }
    
    public static String[] listarNombresDivisas() {
        Set<String> nombresDivisas = new TreeSet<>();

        Properties properties = cargarArchivoProperties(rutaArchivo);
        for (String key : properties.stringPropertyNames()) {
            String[] parts = key.split("\\.");
            
            if (parts.length == 2 && parts[1].equals("nombreDivisa")) {
                nombresDivisas.add(properties.getProperty(key));
            }
        }

        return nombresDivisas.toArray(new String[0]);
    }
    
    public static String encontrarClave(String propiedadDivisa) {
        Properties properties = cargarArchivoProperties(rutaArchivo);
        for (String key : properties.stringPropertyNames()) {
            String[] parts = key.split("\\.");
            
            if (parts.length == 2 && parts[1].equals("nombreDivisa") && properties.getProperty(key).equals(propiedadDivisa)) {
                return parts[0];
            }
        }
        return null;
    }
	
	public String encontrarValor() {
		return "mundo";
	}

}

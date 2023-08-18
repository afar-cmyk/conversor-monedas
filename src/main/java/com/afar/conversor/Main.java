package com.afar.conversor;

import com.afar.conversor.interfaz.InterfazGrafica;

public class Main {
    public static void main(String[] args) {
    	    
    	InterfazGrafica gui = new InterfazGrafica();
        
        gui.iniciarInterfaz(args);

    }
}

//public class Main {
//
//	public static void main(String[] args) {
//		
//		Divisa prueba = new Divisa();
//		
//		System.out.println(prueba.obtenerPropiedadesDivisa("cop", "nombreDivisa"));
//		
//		Convertidor prueba2 = new Convertidor();
//		
//		System.out.println("YEN A COP:");
//		System.out.println(prueba2.convertir(1000, "jpy", "cop"));
//		
//		System.out.println("");
//		
//		System.out.println("COP A YEN:");
//		System.out.println(prueba2.convertir(100000, "cop", "jpy"));
//		
//		System.out.println("");
//		
//		System.out.println("COP A USD:");
//		System.out.println(prueba2.convertir(100000, "cop", "usd"));
//
//	}
//
//}

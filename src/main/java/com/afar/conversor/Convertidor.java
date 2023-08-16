package com.afar.conversor;

public class Convertidor {
	
	public Convertidor(String divisaBase, double valorBase, String divisaFinal) {
		System.out.println("Divisa Base: " + divisaBase);
		System.out.println("Valor de la divisa Base: " + valorBase);
		System.out.println("Divisa Final: " + divisaFinal);
	}
	
}


/*- Convertir de la moneda de tu país a Dólar - 0.000247
- Convertir de la moneda de tu país  a Euros - 1.091752
- Convertir de la moneda de tu país  a Libras Esterlinas - 1.271438
- Convertir de la moneda de tu país  a Yen Japonés - 0.006874
- Convertir de la moneda de tu país  a Won sul-coreano - 0.000749   */


//de 1 dolar a peso =  (1 / 0.000247);
// de 1 peso a dolar es retornar el valor de la tasa
// usar el formato de la cadena de caracteres que esta en main para visualizar todos los ceros del valor final

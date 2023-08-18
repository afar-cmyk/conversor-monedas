package com.afar.conversor.interfaz;

import com.afar.conversor.logica.Convertidor;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.text.DecimalFormat;


public class ControlInterfazGrafica {
	
	DecimalFormat df = new DecimalFormat("0.000000");

	@FXML
	private Spinner<Double> valorIngresado;
	@FXML
	private Button botonConvertir;
	@FXML
	private Text valorFinal;
	
	public void initialize() {
		valorFinal.setText("0");
		SpinnerValueFactory<Double> valueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(Double.MIN_VALUE, Double.MAX_VALUE, 0);
	    valorIngresado.setValueFactory(valueFactory);
	}
	
	@FXML
	public void establecerValorFinal() {
		double valorConvertido = new Convertidor().convertir(valorIngresado.getValue(), "cop", "usd");
		
		if(valorConvertido < 1) {
			valorFinal.setText(resultadoFormateado(valorConvertido));
		} else {
			valorFinal.setText(Double.toString(valorConvertido));
		}
	}
	
	private String resultadoFormateado(double valorFinal) {
		String textoValorFinal = df.format(valorFinal);
		return textoValorFinal;
	}
	
}

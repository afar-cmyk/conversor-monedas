package com.afar.conversor.interfaz;

import com.afar.conversor.logica.Convertidor;
import com.afar.conversor.logica.ListarDivisas;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import java.text.DecimalFormat;

public class ControlInterfazGrafica {
	DecimalFormat df = new DecimalFormat("0.000000");
	private String[] listaDivisas = ListarDivisas.listarNombresDivisas();

	@FXML
	private Spinner<Double> valorIngresado;
	@FXML
	private Button botonConvertir;
	@FXML
	private Text valorFinal;
	@FXML
	private Text codigoValorFinal;
	@FXML
	private ChoiceBox<String> divisaBase;
	@FXML
	private ChoiceBox<String> divisaFinal;
	
	public void initialize() {
	    divisaBase.getItems().addAll(listaDivisas);
	    divisaFinal.getItems().addAll(listaDivisas);
		valorFinal.setText("0");
		codigoValorFinal.setText("");
		
		SpinnerValueFactory<Double> valueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(Double.MIN_VALUE, Double.MAX_VALUE, 0);
	    valorIngresado.setValueFactory(valueFactory);
	    
	    divisaFinal.setOnAction(this::establecerCodigoValorFinal);
	}
	
	@FXML
	public void establecerValorFinal() {
		Double valorIngresado = this.valorIngresado.getValue();
		String divisaBase = ListarDivisas.encontrarClave(this.divisaBase.getValue());
		String divisaFinal = ListarDivisas.encontrarClave(this.divisaFinal.getValue());
		
		double valorConvertido = Convertidor.convertir(valorIngresado, divisaBase, divisaFinal);
		
		if(valorConvertido < 1) {
			valorFinal.setText(resultadoFormateado(valorConvertido));
		} else {
			valorFinal.setText(Double.toString(valorConvertido));
		}
	}
	
	@FXML
	public void establecerCodigoValorFinal(ActionEvent event) {
		String divisaFinal = ListarDivisas.encontrarClave(this.divisaFinal.getValue());
		
		codigoValorFinal.setText(divisaFinal.toUpperCase());
	}
	
	private String resultadoFormateado(double valorFinal) {
		String textoValorFinal = df.format(valorFinal);
		return textoValorFinal;
	}
	
}

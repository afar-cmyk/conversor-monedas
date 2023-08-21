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
import javafx.util.converter.DoubleStringConverter;
import javafx.scene.control.TextFormatter;


import java.io.IOException;
import java.text.DecimalFormat;

public class ControlInterfazGrafica {
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
	    
	    TextFormatter<Double> textFormatter = new TextFormatter<>(new DoubleStringConverter(), 0.0, change -> {
            String newText = change.getControlNewText();
            if (newText.matches("[0-9]*(\\.[0-9]*)?")) {
                return change;
            } else {
                return null;
            }
        });
	    
	    valorIngresado.getEditor().setTextFormatter(textFormatter);
	    
	    divisaFinal.setOnAction(this::establecerCodigoValorFinal);
	}
	
	@FXML
	public void establecerValorFinal() throws IOException {
		Double valorIngresado = this.valorIngresado.getValue();
		String divisaBase = ListarDivisas.encontrarClave(this.divisaBase.getValue());
		String divisaFinal = ListarDivisas.encontrarClave(this.divisaFinal.getValue());
		
		InterfazGrafica interfazGrafica = new InterfazGrafica();
		
		 if (divisaBase == null) {
			 interfazGrafica.showErrorModal("Seleccione el tipo de divisa base");
		    } else if (divisaFinal == null) {
		        interfazGrafica.showErrorModal("Seleccione el tipo de divisa final");
		    } else {
				double valorConvertido = Convertidor.convertir(valorIngresado, divisaBase, divisaFinal);
				
				valorFinal.setText(resultadoFormateado(valorConvertido));
		    }
	}
	
	@FXML
	public void establecerCodigoValorFinal(ActionEvent event) {
		String divisaFinal = ListarDivisas.encontrarClave(this.divisaFinal.getValue());
		
		codigoValorFinal.setText(divisaFinal.toUpperCase());
	}
	
	private String resultadoFormateado(double valorFinal) {
		DecimalFormat df = new DecimalFormat("0.000000");
		String textoValorFinal = df.format(valorFinal);
		return textoValorFinal;
	}
	
}

package com.afar.conversor.interfaz;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ControladorErrorModal {
	@FXML
	private Text mensajeModal;
	
	public void establecerTextoModal(String mensajeError) {	
		mensajeModal.setText(mensajeError);
	}
}

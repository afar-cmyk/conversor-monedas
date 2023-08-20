package com.afar.conversor.interfaz;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class InterfazGrafica extends Application {
	private static Stage primaryStage;
	private TabPane mainLayout;
	
	ControlInterfazGrafica prueba = new ControlInterfazGrafica();
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		InterfazGrafica.primaryStage = primaryStage;
		InterfazGrafica.primaryStage.setTitle("Conversor Universal");
		showMainView();
	}
	
	private void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(InterfazGrafica.class.getResource("MainView.fxml"));
		
		mainLayout = loader.load();
		mainLayout.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void showErrorModal() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(InterfazGrafica.class.getResource("ErrorModal.fxml"));
		BorderPane errorModal = loader.load();
		
		Stage addErrorModalStage = new Stage();
		addErrorModalStage.setTitle("¡Error!");
		addErrorModalStage.initModality(Modality.WINDOW_MODAL);
		addErrorModalStage.initOwner(primaryStage);
		
		Scene scene = new Scene(errorModal);
		addErrorModalStage.setScene(scene);
		addErrorModalStage.showAndWait();
	}

    public void iniciarInterfaz(String[] args) {
        launch(args);
    }

}

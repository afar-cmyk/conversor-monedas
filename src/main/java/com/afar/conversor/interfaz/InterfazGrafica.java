package com.afar.conversor.interfaz;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.fxml.FXMLLoader;

public class InterfazGrafica extends Application {
	private Stage primaryStage;
	private TabPane mainLayout;
	
	ControlInterfazGrafica prueba = new ControlInterfazGrafica();
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Conversor Universal");
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

    public void iniciarInterfaz(String[] args) {
        launch(args);
    }

}

package com.afar.conversor;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	private Stage primaryStage;
	private TabPane mainLayout;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Conversor Universal");
		showMainView();
	}
	
	private void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainView.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
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
//		System.out.println("YEN A COP FORMATEADO:");
//		prueba2.resultadoFormateado();
//		
//		System.out.println("");
//		
//		System.out.println("COP A YEN:");
//		System.out.println(prueba2.convertir(100000, "cop", "jpy"));
//		System.out.println("COP A YEN FORMATEADO:");
//		prueba2.resultadoFormateado();
//		
//		System.out.println("");
//		
//		System.out.println("COP A USD:");
//		System.out.println(prueba2.convertir(100000, "cop", "usd"));
//		System.out.println("COP A USD FORMATEADO:");
//		prueba2.resultadoFormateado();
//
//	}
//
//}

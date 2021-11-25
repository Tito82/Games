package com.tito.dida.games;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Almacen extends Application{
    
      public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent contenedor = new FXMLLoader().load(getClass().getResource("JuegosAlmacen_1.fxml"));
        Scene escena = new Scene (contenedor,790,700);
       
        primaryStage.setScene(escena);
        primaryStage.show();

    
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author calga
 */
public class Paint extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("PaintFXML.fxml"));
       
        stage.setTitle("Paint");
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}

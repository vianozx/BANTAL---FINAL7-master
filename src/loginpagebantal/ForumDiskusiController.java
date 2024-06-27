/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package loginpagebantal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 *
 */
public class ForumDiskusiController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button PelayananTerdekat;
    
    
    @FXML
    private void scene6(ActionEvent event) throws IOException {
        Parent scene6 = FXMLLoader.load(getClass().getResource("FXMLPelayananTerdekat.fxml"));
        Scene scene = new Scene(scene6);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Pelayanan Terdekat");
        stage.show();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

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
 * @author vahrimaulana
 */
public class FXMLHomePageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button profil;

    @FXML
    private Button Dashboard;

    @FXML
    private Button Daftar;

    @FXML
    private Button Login;

    @FXML
    private void daftar(ActionEvent event) throws IOException {
        Parent scene1 = FXMLLoader.load(getClass().getResource("FXMLPilihanPendaftaran.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage p = (Stage) Daftar.getScene().getWindow();
        p.close();
    }

    @FXML
    private void login(ActionEvent event) throws IOException {
        Parent scene1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage p = (Stage) Login.getScene().getWindow();
        p.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package loginpagebantal;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.awt.Desktop;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class DashboardController implements Initializable {

    @FXML
    private Button Dashboard;
    
    @FXML
    private Label namaUser;

    @FXML
    private Button Lihatsemua;

    @FXML
    private Button Tambahkalender;

    @FXML
    private Button memantauperkembangan;

    @FXML
    private Button bProfil;

    @FXML
    private Button bKonsultasi;

    @FXML
    private Button Pelayananterdekat;

    @FXML
    private Button Diskusi;

    @FXML
    private Button loc1;

    @FXML
    private Button loc2;

    @FXML
    private Button loc3;

    @FXML
    private BorderPane mainPane;

    OpenScene bukaScene = new OpenScene();
    java.util.ArrayList< Daftar > listpendaftaranPasien = new java.util.ArrayList <Daftar> ();
   
    XStream xstream = new XStream(new StaxDriver());
    Indeks ind;

    @FXML
    private void Dashboardpsien(ActionEvent event) throws IOException {
        Pane halaman = bukaScene.getPane("FXMLDashboardPasien");
        mainPane.setCenter(halaman);
    }

    @FXML
    private void mantauperkembangan(ActionEvent event) throws IOException {
        Pane halaman = bukaScene.getPane("FXMLMemantauPerkembangan");
        mainPane.setCenter(halaman);
    }

    @FXML
    private void sceneProfil(ActionEvent event) throws IOException {
        Pane halaman = bukaScene.getPane("FXMLprofil");
        mainPane.setCenter(halaman);
    }

    @FXML
    private void sceneKonsultasi(ActionEvent event) throws IOException {
        Pane halaman = bukaScene.getPane("FXMLKonsultasi");
        mainPane.setCenter(halaman);
    }

    @FXML
    private void Tableview(ActionEvent event) throws IOException {
        Parent scene1 = FXMLLoader.load(getClass().getResource("TableKonsultasi.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Jadwal Kosultasi");
        stage.show();
    }

    @FXML
    private void Pelayananterdekat(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("FXMLPelayananTerdekat.fxml"));
        Scene scene = new Scene(scene2);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Pelayanan Terdekat");
        stage.show();
    }

    @FXML
    private void Diskusi(ActionEvent event) throws IOException {
        Parent scene3 = FXMLLoader.load(getClass().getResource("forumDiskusi.fxml"));
        Scene scene = new Scene(scene3);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(" Diskusi ");
        stage.show();
    }

    @FXML
    void loc1(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/Bethesda+Hospital,+Yogyakarta/@-7.78399,110.3776907,15z/data=!4m5!3m4!1s0x0:0x47fd17641c7cde46!8m2!3d-7.78399!4d110.3776907"));
    }

    @FXML
    void loc2(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/Praktik+Psikolog+Nadia/@-7.7785638,110.320109,17z/data=!3m1!4b1!4m5!3m4!1s0x2e7af79ab57e01b7:0xd64fd8981af7eaa5!8m2!3d-7.7785582!4d110.3222735"));
    }

    @FXML
    void loc3(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/Puri+Nirmala+Psychiatric+Hospital/@-7.8008922,110.3746814,17z/data=!3m1!4b1!4m5!3m4!1s0x2e7a578218ec24b9:0xc3e8e3763bcec19c!8m2!3d-7.8010079!4d110.3768579"));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OpenIndeks();
        OpenXml();
        int indeks = ind.getInd();
        Daftar p = listpendaftaranPasien.get(indeks);
        namaUser.setText(p.getNama());
    }
    void OpenXml() {
        FileInputStream inputDoc;

        try {
            inputDoc = new FileInputStream("Listpendaftaranpasien.xml");
            int content;
            char c;
            String s = "";
            while ((content = inputDoc.read()) != -1) {
                c = (char) content;
                s += c;
            }

            listpendaftaranPasien = (java.util.ArrayList<Daftar>) xstream.fromXML(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    void OpenIndeks() {

        FileInputStream berkasMasuk;

        try {
            berkasMasuk = new FileInputStream("Indeks.xml");
            int isi;
            char c;
            String s = "";
            while ((isi = berkasMasuk.read()) != -1) {

                c = (char) isi;
                s = s + c;

            }
            ind = (Indeks) xstream.fromXML(s);
        } catch (Exception e) {
            System.out.println("terjadi kkesallahn");
        }
    }

}

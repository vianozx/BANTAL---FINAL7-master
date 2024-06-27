/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package loginpagebantal;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PendaftaranController implements Initializable {

    @FXML
    private Button SImpan;

    @FXML
    private ToggleGroup kelam;

    @FXML
    private Label label;

    @FXML
    private RadioButton rbPria;

    @FXML
    private RadioButton rbWanita;

    @FXML
    private TextField tKota;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNama;

    @FXML
    private TextField tfNoHP;

    @FXML
    private TextField tfPekerjaan;

    @FXML
    private ChoiceBox tfRiwayat;

    @FXML
    private TextField tfTanggalLahir;

    @FXML
    private TextField tfpassword;

//  ChoiceBox
    private String Nama, Email, Password, TanggalLahir, Riwayatkesehatan, Pekerjaan, nomorhp, kotadankab, Jkelamin;
    XStream xstream = new XStream(new StaxDriver());

    ArrayList<Daftar> listpendaftaranPasien = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tfRiwayat.getItems().addAll("Iya", "Tidak ");

        OpenXml();

    }

    @FXML
    public void simpanButton(ActionEvent event) throws IOException {

        File f = new File("Listpendaftaranpasien.xml");
        if (f.exists() && !f.isDirectory()) {
            System.out.println("file nya adaaa");
            OpenXml();
        }

        if (rbPria.isSelected()) {
            Jkelamin = "Laki - Laki";
        } else {
            Jkelamin = "Perempuan";
        }

        Nama = (String) tfNama.getText();
        Email = (String) tfEmail.getText();
        Password = (String) tfpassword.getText();
        TanggalLahir = (String) tfTanggalLahir.getText();
        Riwayatkesehatan = (String) tfRiwayat.getValue();
        Pekerjaan = (String) tfPekerjaan.getText();
        nomorhp = (String) tfNoHP.getText();
        kotadankab = (String) tKota.getText();
        listpendaftaranPasien.add(new Daftar(Email, Nama, Password, TanggalLahir, Riwayatkesehatan, Pekerjaan, nomorhp, kotadankab, Jkelamin));
        SaveAndCreate();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage Keluar = (Stage) SImpan.getScene().getWindow();
        Keluar.close();

        // TODO
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

            listpendaftaranPasien = (ArrayList<Daftar>) xstream.fromXML(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void SaveAndCreate() {
        FileOutputStream outputDoc;
        String xml = xstream.toXML(listpendaftaranPasien);
        File f = new File("Listpendaftaranpasien.xml");
        try {
            byte[] data = xml.getBytes();
            outputDoc = new FileOutputStream("Listpendaftaranpasien.xml");
            outputDoc.write(data);
            outputDoc.close();
            System.out.println("add data success");
        } catch (Exception error) {
            System.err.println("An error occur: " + error.getMessage());
        }
    }
}

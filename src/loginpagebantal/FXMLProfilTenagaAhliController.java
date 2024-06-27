/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package loginpagebantal;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vahrimaulana
 */
public class FXMLProfilTenagaAhliController implements Initializable {

//    @FXML
//    private Button logout;
//    
//    @FXML
//    private Button SImpan;
//
//    @FXML
//    private ToggleGroup kelam;
//
//    @FXML
//    private Label label;
//
//    @FXML
//    private RadioButton rbPria;
//
//    @FXML
//    private RadioButton rbWanita;
//
//    @FXML
//    private TextField tKota;
//
//    @FXML
//    private TextField tfEmail;
//
//    @FXML
//    private TextField tfNama;
//
//    @FXML
//    private TextField tfNoHP;
//
//    @FXML
//    private TextField tfPengalamanKerja;
//
//    @FXML
//    private TextField tfJenjangPendidikan;
//
//    @FXML
//    private TextField tfTanggalLahir;
//
//    @FXML
//    private TextField tfpassword;
//    
//    @FXML
//    private TextField JenKelamin;
    
    
//      @FXML
//    private TextField JenKelamin;
//
//    @FXML
//    private TextField tKota;
//
//    @FXML
//    private TextField tfEmail;
//
//    @FXML
//    private TextField tfJenjangPendidikan;
//
//    @FXML
//    private TextField tfNama;
//
//    @FXML
//    private TextField tfNoHP;
//
//    @FXML
//    private TextField tfPengalamanKerja;
//
//    @FXML
//    private TextField tfTanggalLahir;
//
//    @FXML
//    private TextField tfpassword;
//    
//    @FXML
//    private Button logout;
    
     @FXML
    private TextField JenKelamin;

    @FXML
    private Button logout;

    @FXML
    private TextField tKota;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfJenjangPendidikan;

    @FXML
    private TextField tfNama;

    @FXML
    private TextField tfNoHP;

    @FXML
    private TextField tfPengalamanKerja;

    @FXML
    private TextField tfTanggalLahir;

    @FXML
    private PasswordField tfpassword;


    
     java.util.ArrayList< DaftarTenagaAhli> listpendaftarantnahli = new java.util.ArrayList<DaftarTenagaAhli>();

    XStream xstream = new XStream(new StaxDriver());
    Indeks ind;
    
   
   @FXML
    private void keluar(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(scene2);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Daftar");
        stage.show();
        Stage Keluar = (Stage) logout.getScene().getWindow();
        Keluar.close();
    }
    
      void OpenData() {

        FileInputStream berkasMasuk;

        try {
            berkasMasuk = new FileInputStream("ListpendaftarantenagaAhli.xml");
            int isi;
            char c;
            String s = "";
            while ((isi = berkasMasuk.read()) != -1) {

                c = (char) isi;
                s = s + c;

            }
            listpendaftarantnahli = (java.util.ArrayList<DaftarTenagaAhli>) xstream.fromXML(s);
        } catch (Exception e) {
            System.out.println("terjadi kkesallahn");
        }
    }

    void simpanData() {
        String xml = xstream.toXML(listpendaftarantnahli);
        FileOutputStream outDoc;
        try {
            byte[] data = xml.getBytes("UTF-8");
            outDoc = new FileOutputStream("ListpendaftarantenagaAhli.xml");
            outDoc.write(data);
            outDoc.close();
        } catch (Exception io) {
            System.err.println("An error occurs: " + io.getMessage());
        }
        System.out.println("Data sudah disimpan");
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
     @Override
    public void initialize(URL url, ResourceBundle rb) {

        OpenData();
        simpanData();
        OpenIndeks();

        for (int i = 0; i < listpendaftarantnahli.size(); i++) {
            System.out.println(listpendaftarantnahli.toString());
        }

        DaftarTenagaAhli p = listpendaftarantnahli.get(ind.getInd());
        tfNama.setText(p.getNama());
        tfEmail.setText(p.getEmail());
        tfpassword.setText(p.getPassword());
        tfTanggalLahir.setText(p.getTanggalLahir());
        tfPengalamanKerja.setText(p.getPengalamanKerja());
        tfJenjangPendidikan.setText(p.getJenjangPendidikan());
        tfNoHP.setText(p.getNomorhp());
        tKota.setText(p.getKotadankab());
        JenKelamin.setText(p.getJkelamin());

    }
    
}

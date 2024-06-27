package loginpagebantal;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author HakWork
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button daftar;

    @FXML
    private Button login;

    @FXML
    private Button loginFacebook;

    @FXML
    private Button loginGoogle;
    
    @FXML
    private Label gagal;

    java.util.ArrayList<Daftar> listpendaftaranPasien = new java.util.ArrayList<>();

    java.util.ArrayList<DaftarTenagaAhli> listpendaftaranTenagaAhli = new java.util.ArrayList<>();

    Daftar dataPasien;
    DaftarTenagaAhli dataTenagaAhli;
    Indeks ind;

    @FXML
    private TextField nama;

    @FXML
    private TextField password;

    XStream xstream = new XStream(new StaxDriver());

    @FXML
    void loginFacebook(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.facebook.com/?stype=lo&jlou=AfeASMCI76RQnZAjLxth7OH4sx0vto4Y2NIWpYDpEMN_HCMDr6Quuk3GD_TBVQKpD4Z5RxJBeEu1x5rpTPoeyz3D45QqWUqJ3SzWWcKyEsCgnw&smuh=27119&lh=Ac__gGJLzO8D5qCYChM"));
    }

    @FXML
    void loginGoogle(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://accounts.google.com/signin/v2/identifier?service=accountsettings&continue=https%3A%2F%2Fmyaccount.google.com%2F%3Futm_source%3Dsign_in_no_continue%26pli%3D1&ec=GAlAwAE&flowName=GlifWebSignIn&flowEntry=AddSession"));
    }

    @FXML
    private void scene2(ActionEvent event) throws IOException {
        
        

        for (int i = 0; i < listpendaftaranPasien.size(); i++) {
            dataPasien = listpendaftaranPasien.get(i);
            if(nama.getText().equals("") && password.getText().equals("")){
                gagal.setText("Gagal Login maszeh :p");
                break;
            }
            if (nama.getText().equals(dataPasien.getEmail()) && password.getText().equals(dataPasien.getPassword())) {
                ind = new Indeks(i);
                FileOutputStream outputDoc;
                String xml = xstream.toXML(ind);
                File f = new File("Indeks.xml");
                try {
                    byte[] data = xml.getBytes();
                    outputDoc = new FileOutputStream("Indeks.xml");
                    outputDoc.write(data);
                    outputDoc.close();
                    System.out.println("add data success");
                } catch (Exception error) {
                    System.err.println("An error occur: " + error.getMessage());
                }
                Parent scene2 = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                Scene scene = new Scene(scene2);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Dashboard");
                stage.show();
                Stage Keluar = (Stage) login.getScene().getWindow();
                Keluar.close();
                
               
            
            } 
            else{
                gagal.setText("Gagal Login maszeh :p");
                 
            }
        }
        for (int i = 0; i < listpendaftaranTenagaAhli.size(); i++) {
            dataTenagaAhli = listpendaftaranTenagaAhli.get(i);
            if(nama.getText().equals("") && password.getText().equals("")){
                gagal.setText("Gagal Login maszeh :p");
                break;
            }
            if (nama.getText().equals(dataTenagaAhli.getEmail()) && password.getText().equals(dataTenagaAhli.getPassword())) {
                ind = new Indeks(i);
                FileOutputStream outputDoc;
                String xml = xstream.toXML(ind);
                File f = new File("Indeks.xml");
                try {
                    byte[] data = xml.getBytes();
                    outputDoc = new FileOutputStream("Indeks.xml");
                    outputDoc.write(data);
                    outputDoc.close();
                    System.out.println("add data success");
                } catch (Exception error) {
                    System.err.println("An error occur: " + error.getMessage());
                }
                Parent scene3 = FXMLLoader.load(getClass().getResource("FXMLDashboardTenagaAhli.fxml"));
                Scene scene = new Scene(scene3);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Dashboard");
                stage.show();
                Stage Keluar = (Stage) login.getScene().getWindow();
                Keluar.close();
            } else {
                gagal.setText("Gagal Login maszeh :p");
            }
        }

    }

    @FXML
    private void scene3(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("FXMLPilihanPendaftaran.fxml"));
        Scene scene = new Scene(scene2);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Daftar");
        stage.show();
        Stage Keluar = (Stage) daftar.getScene().getWindow();
        Keluar.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OpenXmlAhli();
        OpenXmlPasien();
    }

    void OpenXmlPasien() {
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

    void OpenXmlAhli() {
        FileInputStream inputDoc;

        try {
            inputDoc = new FileInputStream("ListpendaftarantenagaAhli.xml");
            int content;
            char c;
            String s = "";
            while ((content = inputDoc.read()) != -1) {
                c = (char) content;
                s += c;
            }

            listpendaftaranTenagaAhli = (java.util.ArrayList<DaftarTenagaAhli>) xstream.fromXML(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLmemantauPerkembanganController implements Initializable {
XStream xstream = new XStream(new StaxDriver());
    private double depresi, tinggi, cemas, durasi;
    private boolean gejala, konsult, adhd, ledakan;
    private String tanggal;
    ArrayList<DataMood> datamood = new ArrayList<DataMood>();
    
    
    @FXML
    private DatePicker dpTanggal;
    
    @FXML
    private TextField catatanperk;
    
    @FXML
    private Button simpan;
    
    @FXML
    private Button lanjut;
    
    @FXML
    private TextField durasiTidur;
    
    @FXML
    private RadioButton dep0;
    @FXML
    private RadioButton dep1;
    @FXML
    private RadioButton dep2;
    @FXML
    private RadioButton dep3;
    
    @FXML
    private RadioButton ting0;
    @FXML
    private RadioButton ting1;
    @FXML
    private RadioButton ting2;
    @FXML
    private RadioButton ting3;
    
    @FXML
    private RadioButton cem0;
    @FXML
    private RadioButton cem1;
    @FXML
    private RadioButton cem2;
    @FXML
    private RadioButton cem3;
    
    
    
    @FXML
    private CheckBox cbGejala;
    @FXML
    private CheckBox cbLedakan;
    @FXML
    private CheckBox cbTenaga;
    @FXML
    private CheckBox sulitfokus;
    
    @FXML
    public void sceneLanjut(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TampilChart.fxml"));
        Parent scene2 = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(scene2));
        stage.show();
    }
    
    @FXML
    public void Simpanbtn(ActionEvent event){
    File f = new File("ListKonsultasi.xml");
        if (f.exists() && !f.isDirectory()) {
            System.out.println("file nya adaaa");
            OpenXml();
        }
    LocalDate ttanggal = dpTanggal.getValue();
    tanggal = ttanggal.toString();
//        mood depresi
    if (dep0.isSelected()){
        depresi = 0;
    }
    else if ( dep1.isSelected()){
        depresi = 1;
    }
    else if ( dep2.isSelected()){
        depresi = 2;
    }
    else if ( dep3.isSelected()){
        depresi = 3;
    }
    
//    mood Tinggi
    if (ting0.isSelected()){
        tinggi = 0;
    }
    else if(ting1.isSelected()){
        tinggi = 1;
    }
    else if(ting2.isSelected()){
        tinggi = 2;
    }
    else if(ting3.isSelected()){
        tinggi = 3;
    }
    
//    mood cemas
    if (cem0.isSelected()){
        cemas = 0;
    }
    else if (cem1.isSelected()){
        cemas = 1;
    }
    else if (cem2.isSelected()){
        cemas = 2;
    }
    else if (cem3.isSelected()){
        cemas = 3;
    }
    
//    checkbox
    gejala = cbGejala.isSelected();
    konsult = cbTenaga.isSelected();
    adhd = sulitfokus.isSelected();
    ledakan = cbLedakan.isSelected();
    
    durasi = Double.parseDouble(durasiTidur.getText());
    
    
    
    datamood.add(new DataMood(durasi, depresi, tinggi, cemas, gejala, konsult, adhd, ledakan, tanggal));
    SaveAndCreate(); 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     void OpenXml() {
        FileInputStream inputDoc;

        try {
            inputDoc = new FileInputStream("DataMoodChart.xml");
            int content;
            char c;
            String s = "";
            while ((content = inputDoc.read()) != -1) {
                c = (char) content;
                s += c;
            }

            datamood = (ArrayList<DataMood>) xstream.fromXML(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     void SaveAndCreate() {
        FileOutputStream outputDoc;
        String xml = xstream.toXML(datamood);
        File f = new File("DataMoodChart.xml");
        try {
            byte[] data = xml.getBytes();
            outputDoc = new FileOutputStream("DataMoodChart.xml");
            outputDoc.write(data);
            outputDoc.close();
            System.out.println("add data success");
        } catch (Exception error) {
            System.err.println("An error occur: " + error.getMessage());
        }
    }

    @FXML
    private void scenememantauperkembangan (ActionEvent event) throws IOException {
        Parent scene5 = FXMLLoader.load(getClass().getResource("FXMLmemantauPerkembanganChart.fxml"));
        Scene scene = new Scene(scene5);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Memantau Perkembangan chart");
        stage.show();
    }
    
}

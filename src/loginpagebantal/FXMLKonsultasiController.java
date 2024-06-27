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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vahrimaulana
 */
public class FXMLKonsultasiController implements Initializable {
    
    @FXML
    private ChoiceBox ksWaktu;
    
    @FXML
    private ChoiceBox ksAlamat;
    
    @FXML
    private CheckBox kstatapmuka;
    
    @FXML
    private CheckBox kstdktatapmuka;
    
    @FXML
    private TextField ksKeluhan;
    
    @FXML
    private Button kssimpan;
    
    @FXML
    private Button kslanjut;
    
    @FXML
    private DatePicker kstanggal;
    
    private String tanggal, waktu, tatapMuka, alamat, keluhan;
    
    XStream xstream = new XStream(new StaxDriver());
    
    ArrayList<Konsultasi> listKonsultasi = new ArrayList<>();
    
    @FXML
    private void checkboxttpmka (){
    if (kstatapmuka.isSelected()){        
        ksAlamat.getItems().remove("-");
        }
    if (! kstatapmuka.isSelected()){
        ksAlamat.getItems().add("-");
    }
    }
    
    @FXML
    private void scene3(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TableKonsultasi.fxml"));
        Parent scene2 = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(scene2));
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        ksWaktu.setValue("09.00 - 10.35");
        ksWaktu.getItems().addAll("09.00 - 10.35", "12.35 - 13.15", "14.00 - 15.15", "15.30 - 17.00");
        
       
        ksAlamat.setValue("-");
        ksAlamat.getItems().addAll("-", "Jl.nglanjaran no.3 (Dr.Vahri)","Jl.Barbasari no.5(Dr.Fahni)","Jl.Margosari no.10(Dr.Fikri)", "Jl.Kaliurang km.15(Dr.Viano)");
        
        OpenXml();
    }   
    
    
    @FXML
    public void simpanButton(ActionEvent event){
        
        File f = new File("ListKonsultasi.xml");
        if (f.exists() && !f.isDirectory()) {
            System.out.println("file nya adaaa");
            OpenXml();
        }
        
        LocalDate ttanggal = kstanggal.getValue();
        tanggal = ttanggal.toString();
        waktu = (String) ksWaktu.getValue();
        if (kstatapmuka.isSelected()){
            tatapMuka = "iya";
        }else{
            tatapMuka = "tidak";
        }
        
        alamat = (String) ksAlamat.getValue();
        keluhan = ksKeluhan.getText();
        System.out.println(tanggal);
        System.out.println(waktu);
        System.out.println(tatapMuka);
        System.out.println(alamat);
        System.out.println(keluhan);
        
        listKonsultasi.add(new Konsultasi(alamat, tanggal, waktu, tatapMuka, keluhan));
        
        SaveAndCreate();

           
        
    }
    void OpenXml() {
        FileInputStream inputDoc;

        try {
            inputDoc = new FileInputStream("ListKonsultasi.xml");
            int content;
            char c;
            String s = "";
            while ((content = inputDoc.read()) != -1) {
                c = (char) content;
                s += c;
            }

            listKonsultasi = (ArrayList<Konsultasi>) xstream.fromXML(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    void SaveAndCreate() {
        FileOutputStream outputDoc;
        String xml = xstream.toXML(listKonsultasi);
        File f = new File("ListKonsultasi.xml");
        try {
            byte[] data = xml.getBytes();
            outputDoc = new FileOutputStream("ListKonsultasi.xml");
            outputDoc.write(data);
            outputDoc.close();
            System.out.println("add data success");
        } catch (Exception error) {
            System.err.println("An error occur: " + error.getMessage());
        }
    }
    
    
}
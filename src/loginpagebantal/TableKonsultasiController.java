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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class TableKonsultasiController implements Initializable {

    @FXML
    private Button Simpan;
    
    @FXML
    private Button Edit;
            
    @FXML
    private TableView <Konsultasi> TableKonsultasi;
    
    
    @FXML
    private TableColumn <Konsultasi,String> Alamat;
    
    @FXML
    private TableColumn <Konsultasi,String> Tanggalhari;
    
    @FXML
    private TableColumn <Konsultasi,String> tcwaktu;
    
    @FXML
    private TableColumn <Konsultasi,String> tatapmuka;
    
    @FXML
    private TableColumn <Konsultasi,String> Keluhan;
    
    
    ArrayList<Konsultasi> listKon = new ArrayList<Konsultasi>();
    
    ObservableList datakonsultasi = observableArrayList();
    XStream xstream = new XStream(new StaxDriver());
    
    @FXML
    private void hapusButton(ActionEvent event) {
        TableView.TableViewSelectionModel selectionModel = TableKonsultasi.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        int i = selectionModel.getSelectedIndex();

        if (i >= 0) {
            datakonsultasi.remove(i);
            listKon.remove(i);
        }

        simpanData();
    }
    
    void OpenData() {
        
        FileInputStream berkasMasuk;

        try {
            berkasMasuk = new FileInputStream("ListKonsultasi.xml");
            int isi;
            char c;
            String s = "";
            while ((isi = berkasMasuk.read()) != -1) {

                c = (char) isi;
                s = s + c;

            }

            listKon = (ArrayList<Konsultasi>) xstream.fromXML(s);
            berkasMasuk.close();
        } catch (Exception e) {
            System.out.println("terjadi kkesallahn");
        }
    }
    void simpanData() {
        String xml = xstream.toXML(listKon);
        FileOutputStream outDoc;
        try {
            byte[] data = xml.getBytes("UTF-8");
            outDoc = new FileOutputStream("ListKonsultasi.xml");
            outDoc.write(data);
            outDoc.close();
        } catch (Exception io) {
            System.err.println("An error occurs: " + io.getMessage());
        }
        System.out.println("Data sudah disimpan");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      Alamat.setCellValueFactory(new PropertyValueFactory <> ("Alamat"));
      Keluhan.setCellValueFactory(new PropertyValueFactory <> ("Keluhan"));
      tatapmuka.setCellValueFactory(new PropertyValueFactory <> ("tatapmuka"));
      tcwaktu.setCellValueFactory(new PropertyValueFactory <> ("Waktu"));
      Tanggalhari.setCellValueFactory(new PropertyValueFactory <> ("Tanggalhari"));
      
      OpenData();
      simpanData();
      File f = new File("ListKonsultasi.xml");
      if (f.exists() && !f.isDirectory()){
          OpenData();
          for(int i = 0; i < listKon.size(); i++){
              datakonsultasi.add(listKon.get(i));
          }
      }
      for (int i = 0 ;i<listKon.size();i++){
          System.out.println(listKon.toString());
      }
      TableKonsultasi.setItems(datakonsultasi);
    }
}
  
        
        
        
        

        
        
        
        
      
      


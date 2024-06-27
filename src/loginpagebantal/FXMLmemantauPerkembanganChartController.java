 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package loginpagebantal;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLmemantauPerkembanganChartController implements Initializable {
    int adhd, bipolar,psikotik;

    XStream xstream = new XStream(new StaxDriver());
    ArrayList<DataMood> datamood = new ArrayList<DataMood>();
    DataMood data;
    XYChart.Series depresi = new XYChart.Series<>();
    XYChart.Series tinggi = new XYChart.Series<>();
    XYChart.Series cemas = new XYChart.Series<>();
    
    XYChart.Series durasi = new XYChart.Series<>();
    
    ObservableList<PieChart.Data> dataGejala =FXCollections.observableArrayList();

    @FXML
    private LineChart chartMood;
    
    @FXML
    private LineChart cdurasi;
    
    @FXML
    private PieChart pcGejala;
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File f = new File("ListKonsultasi.xml");
        if (f.exists() && !f.isDirectory()) {
            System.out.println("file nya adaaa");
            OpenXml();
        }
        OpenXml();
        
        //depresi
        depresi.setName("Depresi");
        for(int i = 0; i<datamood.size();i++){
            data = (DataMood) datamood.get(i);
            depresi.getData().add(new XYChart.Data(data.getTanggal().toString(), data.getDepresi()));
        }
        
        tinggi.setName("Tinggi");
        for(int i = 0; i<datamood.size();i++){
            data = (DataMood) datamood.get(i);
            tinggi.getData().add(new XYChart.Data(data.getTanggal().toString(), data.getTinggi()));
        }
        
        cemas.setName("Cemas");
        for(int i = 0; i<datamood.size();i++){
            data = (DataMood) datamood.get(i);
            cemas.getData().add(new XYChart.Data(data.getTanggal().toString(), data.getCemas()));
        }
        
        chartMood.getData().addAll(depresi,tinggi,cemas);
        
        durasi.setName("Durasti tidur (jam)");
        for(int i = 0; i<datamood.size();i++){
            data = (DataMood) datamood.get(i);
            durasi.getData().add(new XYChart.Data(data.getTanggal().toString(), data.getDurasiTidur()));
        }
        cdurasi.getData().addAll(durasi);
        
        for(int i = 0; i<datamood.size();i++){
            data = (DataMood) datamood.get(i);
            if(data.isAdhd()==true){
               adhd++;
            }
            else if(data.isGejala()==true){
                psikotik++;
            }
            else if(data.isLedakan()==true){
                bipolar++;
            }
        }
        dataGejala.add(new PieChart.Data("ADHD", adhd));
        dataGejala.add(new PieChart.Data("Psikotik", psikotik));
        dataGejala.add(new PieChart.Data("Bipolar", bipolar));
        pcGejala.setData(dataGejala);
        
        
        
        
        
        
        
        
        
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
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    XYChart.Series depresi = new XYChart.Series<>();
//    XYChart.Series tinggi = new XYChart.Series<>();
//    
//    
//    
//    XYChart.Series datagejala = new XYChart.Series<>();
//    XYChart.Series dataKonsultasi = new XYChart.Series<>();
//    XYChart.Series datalc = new XYChart.Series<>();
//    
//    @FXML
//    private LineChart lcDurasi;
//    
//    @FXML
//    private BarChart bcGejalaKunjung;
//    
//    
//    @FXML
//    private BarChart bcMood;
//    
//    @FXML
//    private Button bDashProfil;
//    
//    
//    
//    
//    
//    
//    
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        //piechart mood                                   
//        
//        depresi.setName("Depresi");       
//        depresi.getData().add(new XYChart.Data("1", 3));
//        depresi.getData().add(new XYChart.Data("2", 2));
//        depresi.getData().add(new XYChart.Data("3", 3));
//        depresi.getData().add(new XYChart.Data("4", 2));
//        depresi.getData().add(new XYChart.Data("5", 0));
//        depresi.getData().add(new XYChart.Data("6", 1));
//        depresi.getData().add(new XYChart.Data("7", 0));
//        
//        
//        tinggi.setName("tinggi");       
//        tinggi.getData().add(new XYChart.Data("1", 3));
//        tinggi.getData().add(new XYChart.Data("2", 1));
//        tinggi.getData().add(new XYChart.Data("3", 2));
//        tinggi.getData().add(new XYChart.Data("4", 0));
//        tinggi.getData().add(new XYChart.Data("5", 0));
//        tinggi.getData().add(new XYChart.Data("6", 1));
//        tinggi.getData().add(new XYChart.Data("7", 3));
//        
//        
//        
//        bcMood.getData().addAll(depresi, tinggi);
//        
//        
//        
//        
//        
//        //linechar durasi tidur
//        datalc.setName("Durasi tidur");
//        datalc.getData().add(new XYChart.Data("1" , 8));
//        datalc.getData().add(new XYChart.Data("2" , 7));
//        datalc.getData().add(new XYChart.Data("3" , 4));
//        datalc.getData().add(new XYChart.Data("4" , 6));
//        datalc.getData().add(new XYChart.Data("5" , 8));
//        datalc.getData().add(new XYChart.Data("6" , 9));
//        datalc.getData().add(new XYChart.Data("7" , 12));
//        
//        lcDurasi.getData().addAll(datalc);
        
        
        
    
    

//Bar chart gejala 
//psikotik dan kunjungan tenaga ahli
//        datagejala.getData().add(new XYChart.Data("gejala" , 8));
//        dataKonsultasi.getData().add(new XYChart.Data("konsultasi" , 7));
//        
//        bcGejalaKunjung.getData().addAll(datagejala, dataKonsultasi);


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginpagebantal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class KonsultasiList {
    private ObservableList<Konsultasi> listKon;
    
    public KonsultasiList(){
        listKon = FXCollections.observableArrayList();
        
    }
    public ObservableList<Konsultasi> getDataKonsultasi(){
        return this.listKon;
    }
    public void setData (String alamat, String tanggal,String waktu,String tatapMuka,String keluhan){
        listKon.add(new Konsultasi(alamat, tanggal, waktu, tatapMuka, keluhan));
    }
    public void showData(){
        for (int i = 0 ; i< 1 ; i++){
            System.out.println(listKon.toString());
        }
    }
        
}

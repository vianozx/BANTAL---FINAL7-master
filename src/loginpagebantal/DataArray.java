/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginpagebantal;

/**
 *
 * @author user
 */
public class DataArray {
    private int idx;
    Konsultasi[] dataKon;
    
    public DataArray(int n){       
        this.idx = 0;
        this.dataKon = new Konsultasi[n];
    }
    
    public void addDataKon(String alamat, String tanggal, String waktu, String tatapMuka, String keluhan){
        dataKon[idx] = new Konsultasi(alamat, tanggal, waktu, tatapMuka, keluhan);   
    }
    
    public void incrementIdx(){
        idx++;
    }
    
    public void showData(){
        for(int i = 0; i<dataKon.length;i++){
            System.out.println(dataKon[i]);
        }
    }
    
    
}

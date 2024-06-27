/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginpagebantal;

/**
 *
 * @author MSI
 */
public class Konsultasi {

    String alamat;
    String tanggalhari;
    String waktu;
    String tatapmuka;
    String keluhan;

    public Konsultasi(String Alamat, String Tanggalhari, String waktu, String tatapmuka, String Keluhan ) {
        this.alamat = Alamat;
        this.tanggalhari = Tanggalhari;
        this.waktu = waktu;
        this.tatapmuka = tatapmuka;
        this.keluhan = Keluhan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String Alamat) {
        this.alamat = Alamat;
    }

    public String getTanggalhari() {
        return tanggalhari;
    }

    public void setTanggalhari(String Tanggalhari) {
        this.tanggalhari = Tanggalhari;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getTatapmuka() {
        return tatapmuka;
    }

    public void setTatapmuka(String tatapmuka) {
        this.tatapmuka = tatapmuka;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String Keluhan) {
        this.keluhan = Keluhan;
    }

    @Override
    public String toString() {
        return "Konsultasi{" + "alamat=" + alamat + ", tanggalhari=" + tanggalhari + ", waktu=" + waktu + ", tatapmuka=" + tatapmuka + ", keluhan=" + keluhan + '}';
    }
    
    

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginpagebantal;

/**
 *
 * @author user
 */
public class DataMood {
    private double durasiTidur, depresi, tinggi, cemas;
    private boolean gejala, konsult, adhd, ledakan;
    private String tanggal;

    public DataMood(double durasiTidur, double depresi, double tinggi, double cemas, boolean gejala, boolean konsult, boolean adhd, boolean ledakan, String tanggal) {
        this.durasiTidur = durasiTidur;
        this.depresi = depresi;
        this.tinggi = tinggi;
        this.cemas = cemas;
        this.gejala = gejala;
        this.konsult = konsult;
        this.adhd = adhd;
        this.ledakan = ledakan;
        this.tanggal = tanggal;
    }

    public double getDurasiTidur() {
        return durasiTidur;
    }

    public void setDurasiTidur(double durasiTidur) {
        this.durasiTidur = durasiTidur;
    }

    public double getDepresi() {
        return depresi;
    }

    public void setDepresi(double depresi) {
        this.depresi = depresi;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    public double getCemas() {
        return cemas;
    }

    public void setCemas(double cemas) {
        this.cemas = cemas;
    }

    public boolean isGejala() {
        return gejala;
    }

    public void setGejala(boolean gejala) {
        this.gejala = gejala;
    }

    public boolean isKonsult() {
        return konsult;
    }

    public void setKonsult(boolean konsult) {
        this.konsult = konsult;
    }

    public boolean isAdhd() {
        return adhd;
    }

    public void setAdhd(boolean adhd) {
        this.adhd = adhd;
    }

    public boolean isLedakan() {
        return ledakan;
    }

    public void setLedakan(boolean ledakan) {
        this.ledakan = ledakan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    
    
    
    
   

    
}

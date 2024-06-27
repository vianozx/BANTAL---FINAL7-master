/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginpagebantal;

/**
 *
 * @author MSI
 */
public class Daftar {

    String Email;
    String Nama;
    String Password;
    String Tanggallahir;
    String RiwayatKesehatan;
    String Pekerjaan;
    String Nomorhp;
    String kabdankota;
    String JenisKelamin;

    public Daftar(String Email, String Nama, String Password, String Tanggallahir, String RiwayatKesehatan, String Pekerjaan, String Nomorhp, String kabdankota, String JenisKelamin) {
        this.Email = Email;
        this.Nama = Nama;
        this.Password = Password;
        this.Tanggallahir = Tanggallahir;
        this.RiwayatKesehatan = RiwayatKesehatan;
        this.Pekerjaan = Pekerjaan;
        this.Nomorhp = Nomorhp;
        this.kabdankota = kabdankota;
        this.JenisKelamin = JenisKelamin;
        
        
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getTanggallahir() {
        return Tanggallahir;
    }

    public void setTanggallahir(String Tanggallahir) {
        this.Tanggallahir = Tanggallahir;
    }

    public String getRiwayatKesehatan() {
        return RiwayatKesehatan;
    }

    public void setRiwayatKesehatan(String RiwayatKesehatan) {
        this.RiwayatKesehatan = RiwayatKesehatan;
    }

    public String getPekerjaan() {
        return Pekerjaan;
    }

    public void setPekerjaan(String Pekerjaan) {
        this.Pekerjaan = Pekerjaan;
    }

    public String getNomorhp() {
        return Nomorhp;
    }

    public void setNomorhp(String Nomorhp) {
        this.Nomorhp = Nomorhp;
    }

    public String getKabdankota() {
        return kabdankota;
    }

    public void setKabdankota(String kabdankota) {
        this.kabdankota = kabdankota;
    }

    public String getJenisKelamin() {
        return JenisKelamin;
    }

    public void setJenisKelamin(String JenisKelamin) {
        this.JenisKelamin = JenisKelamin;
    }

}

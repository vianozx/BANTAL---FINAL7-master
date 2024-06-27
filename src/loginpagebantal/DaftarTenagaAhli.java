/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginpagebantal;

/**
 *
 * @author MSI
 */
public class DaftarTenagaAhli {

    private String Nama;
    private String Email;
    private String Password;
    private String TanggalLahir;
    private String PengalamanKerja;
    private String JenjangPendidikan;
    private String nomorhp;
    private String kotadankab;
    private String Jkelamin;

    public DaftarTenagaAhli(String Nama, String Email, String Password, String TanggalLahir, String PengalamanKerja, String JenjangPendidikan, String nomorhp, String kotadankab, String Jkelamin) {
        this.Nama = Nama;
        this.Email = Email;
        this.Password = Password;
        this.TanggalLahir = TanggalLahir;
        this.PengalamanKerja = PengalamanKerja;
        this.JenjangPendidikan = JenjangPendidikan;
        this.nomorhp = nomorhp;
        this.kotadankab = kotadankab;
        this.Jkelamin = Jkelamin;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getTanggalLahir() {
        return TanggalLahir;
    }

    public void setTanggalLahir(String TanggalLahir) {
        this.TanggalLahir = TanggalLahir;
    }

    public String getPengalamanKerja() {
        return PengalamanKerja;
    }

    public void setPengalamanKerja(String PengalamanKerja) {
        this.PengalamanKerja = PengalamanKerja;
    }

    public String getJenjangPendidikan() {
        return JenjangPendidikan;
    }

    public void setJenjangPendidikan(String JenjangPendidikan) {
        this.JenjangPendidikan = JenjangPendidikan;
    }

    public String getNomorhp() {
        return nomorhp;
    }

    public void setNomorhp(String nomorhp) {
        this.nomorhp = nomorhp;
    }

    public String getKotadankab() {
        return kotadankab;
    }

    public void setKotadankab(String kotadankab) {
        this.kotadankab = kotadankab;
    }

    public String getJkelamin() {
        return Jkelamin;
    }

    public void setJkelamin(String Jkelamin) {
        this.Jkelamin = Jkelamin;
    }

}

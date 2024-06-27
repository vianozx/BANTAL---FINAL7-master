/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package loginpagebantal;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author vahrimaulana
 */
public class FXMLPelayananTerdekatController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane mainPane;

    @FXML
    private Button Diskusi;

    OpenScene bukaScene = new OpenScene();
    @FXML
    private Button loc1;
    @FXML
    private Button loc2;
    @FXML
    private Button loc3;
    @FXML
    private Button loc4;
    @FXML
    private Button loc5;
    @FXML
    private Button loc6;
    @FXML
    private Button loc7;
    @FXML
    private Button loc8;
    @FXML
    private Button loc9;
    @FXML
    private Button loc10;
    @FXML
    private Button loc11;
    @FXML
    private Button loc12;

   
    

    @FXML
    private void diskusi(ActionEvent event) throws IOException {
        Parent scene5 = FXMLLoader.load(getClass().getResource("forumDiskusi.fxml"));
        Scene scene = new Scene(scene5);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(" Diskusi ");
        stage.show();
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


    @FXML
    void loc1(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/Bethesda+Hospital,+Yogyakarta/@-7.78399,110.3776907,15z/data=!4m5!3m4!1s0x0:0x47fd17641c7cde46!8m2!3d-7.78399!4d110.3776907"));
    }

    @FXML
    void loc2(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/Praktik+Psikolog+Nadia/@-7.7785638,110.320109,17z/data=!3m1!4b1!4m5!3m4!1s0x2e7af79ab57e01b7:0xd64fd8981af7eaa5!8m2!3d-7.7785582!4d110.3222735"));
    }

    @FXML
    void loc3(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/Puri+Nirmala+Psychiatric+Hospital/@-7.8008922,110.3746814,17z/data=!3m1!4b1!4m5!3m4!1s0x2e7a578218ec24b9:0xc3e8e3763bcec19c!8m2!3d-7.8010079!4d110.3768579"));
    }

    @FXML
    void loc4(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/Praktik+Psikolog+Mandiri+Christina+Irnawati+S.Psi.,+M.Psi.,Psikolog.,CH.,CT/@-7.5278771,110.7447869,13z/data=!4m9!1m2!2m1!1smandiri+christina+psikolog!3m5!1s0x2e7a1187bfea8a6b:0xb22e8ead8bf03dad!8m2!3d-7.5278755!4d110.8148249!15sChptYW5kaXJpIGNocmlzdGluYSBwc2lrb2xvZyIDiAEBkgEMcHN5Y2hvbG9naXN0"));
    }

    @FXML
    void loc5(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/Praktek+Psikolog+Setiyo+Purwanto+MSi./@-7.5671488,110.7457436,17z/data=!3m1!4b1!4m5!3m4!1s0x2e7a14fc9046cc2d:0x72a10737a5ddb5ac!8m2!3d-7.5671608!4d110.7502248"));
    }

    @FXML
    void loc6(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/Sakina+Biro+Layanan+Psikologi+%26+Bahasa+Ponorogo/@-7.8628032,111.4253666,14z/data=!4m9!1m2!2m1!1sbiro+layanan+psikologi+sakina!3m5!1s0x2e799f5e7a951a8b:0x716dd6a305ad477b!8m2!3d-7.8628032!4d111.4603855!15sCh1iaXJvIGxheWFuYW4gcHNpa29sb2dpIHNha2luYZIBDHBzeWNob2xvZ2lzdA"));
    }

    @FXML
    void loc7(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/WASKITA+-+Biro+Konsultan+Psikologi/@-7.5609544,110.8227186,17z/data=!3m1!4b1!4m5!3m4!1s0x2e7a168f310340b1:0xbd499c28835c685e!8m2!3d-7.5609544!4d110.8272033"));
    }

    @FXML
    void loc8(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/Layanan+Psikologi+Rumah+Mentari/@-7.0034113,110.4620506,17z/data=!3m1!4b1!4m5!3m4!1s0x2e708dd5cfdc1c31:0x7a7868e4a1c3e082!8m2!3d-7.0034173!4d110.4642462"));
    }

    @FXML
    void loc9(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/ARCHANA+Biro+Psikologi,+Riset,+Training,+Konsultan/@-7.5558083,110.8743882,17z/data=!3m1!4b1!4m5!3m4!1s0x2e7a17e8e8ac8427:0x3589f9d041dbb237!8m2!3d-7.5557994!4d110.8765812"));
    }

    @FXML
    void loc10(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/Biro+Konsultasi+Psikologi+Kencana/@-7.5621572,110.7457636,17z/data=!3m1!4b1!4m5!3m4!1s0x2e7a14e552b9f56b:0xce91de2cad41b520!8m2!3d-7.5621572!4d110.7479523"));
    }

    @FXML
    void loc11(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/BIRO+PSIKOLOGI+Smart+Solindo+Consultama/@-7.5338912,110.8223902,17z/data=!3m1!4b1!4m5!3m4!1s0x2e7a16b13a4a1ab9:0xc6778c29683d3739!8m2!3d-7.5338801!4d110.8245564"));
    }

    @FXML
    void loc12(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/Lembaga+Psikologi+Terapan+Pranatama/@-7.5557107,110.8132424,17z/data=!3m1!4b1!4m5!3m4!1s0x2e7a169ba0cdcb75:0x2d22f84c7ae117cb!8m2!3d-7.555737!4d110.8154864"));
    }
}

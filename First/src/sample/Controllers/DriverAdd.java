package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ResourceBundle;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import org.jetbrains.annotations.NotNull;
import sample.ConnectorToMYSQL.Connector;
import sample.SetGet.SetDriver;
import sample.TablesClasses.Driver_table;

public class DriverAdd {

    @FXML
    private AnchorPane Pane_driver;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField AddDriverFirstName;

    @FXML
    private TextField AddDriverLasttName;

    @FXML
    private TextField AddDriverFatherName;

    @FXML
    private TextField AddDriversnils;

    @FXML
    private TextField AddDriverINN;

    @FXML
    private TextField AddDriverSeriaDriverCard;

    @FXML
    private TextField AddDriverNumberDriverCard;

    @FXML
    private Button add_driver;

    @FXML
    private Button retur_btn;

    @FXML
    private TextField AddDriverSeriaPassport;

    @FXML
    private TextField AddDriverNumberPassport;

    @FXML
    private TextField AddDriverCodPassport;

    @FXML
    private DatePicker AddDriverDatePassport;

    @FXML
    private TextArea AddDriverWhoPassport;

    @FXML
    private TextField AddDriverTellNumb1;

    @FXML
    private TextField AddDriverTellNumb2;

    @FXML
    private TextField regestration;

    @FXML
    private DatePicker AddDriverBerdDay;

    @FXML
    private DatePicker AddDriverDateDriverCard;


    @FXML
    void initialize() {
        retur_btn.setOnAction(actionEvent ->{
                retur_btn.getScene().getWindow().hide();
                });
        // Регулярное выражение для инн (10-12 цифр , не начинается с нуля)
       //AddDriverINN.setTextFormatter(new TextFormatter<>(change ->
        //     (change.getText().matches("(^(?!0.*$)([0-9]{12})$)|(^(?!0.*$)([0-9]{10})$)")) ? change : ));
       // AddDriverINN.setTextFormatter(new TextFormatter<>(  ));
        AddDriverNumberDriverCard.setTextFormatter(new TextFormatter<>(change ->
                (change.getControlNewText().matches("([1-9][0-9]*)?")) ? change : null));
        add_driver.setOnAction(actionEvent -> {

            String first_name = AddDriverFirstName.getText().trim();
            String last_name = AddDriverLasttName.getText().trim();
            String father_name = AddDriverFatherName.getText().trim();
            LocalDate birthday = AddDriverBerdDay.getValue();
            String driver_snils = AddDriversnils.getText().trim();
            String driver_inn = AddDriverINN.getText().trim();
            String driver_sdc = AddDriverSeriaDriverCard.getText().trim();
            String driver_ndc = AddDriverNumberDriverCard.getText().trim();
            LocalDate driver_ddc = AddDriverDateDriverCard.getValue();
            String driver_sop = AddDriverSeriaPassport.getText().trim();
            String driver_nop = AddDriverNumberPassport.getText().trim();
            String driver_cop = AddDriverCodPassport.getText().trim();
            LocalDate driver_dop = AddDriverDatePassport.getValue();
            String driver_wop = AddDriverWhoPassport.getText().trim();
            String driver_phone = AddDriverTellNumb1.getText().trim();
            String driver_reg = regestration.getText().trim();
            Date birthday_dat = java.sql.Date.valueOf(birthday);
            Date driver_ddc_dat = java.sql.Date.valueOf(driver_ddc);
            Date driver_dop_dat = java.sql.Date.valueOf(driver_dop);

            if(!first_name.equals("") && !father_name.equals("") && !last_name.equals("")) {
                try {
                    SetDriver.Set(first_name,last_name,
                            father_name,birthday_dat,
                            driver_snils,driver_inn,
                            driver_sdc, driver_ndc,
                            driver_ddc_dat, driver_sop,
                            driver_nop, driver_cop,
                            driver_dop_dat, driver_wop,
                            driver_phone, driver_reg);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Driver_table driver = new Driver_table();

                System.out.println("Polya zapolneny");
            }
            else System.out.println("Заполните поля");

        });
        assert Pane_driver != null : "fx:id=\"Pane_driver\" was not injected: check your FXML file 'Driver_add.fxml'.";
        assert AddDriverFirstName != null : "fx:id=\"AddDriverFirstName\" was not injected: check your FXML file 'Driver_add.fxml'.";
        assert AddDriverLasttName != null : "fx:id=\"AddDriverLasttName\" was not injected: check your FXML file 'Driver_add.fxml'.";
        assert AddDriverFatherName != null : "fx:id=\"AddDriverFatherName\" was not injected: check your FXML file 'Driver_add.fxml'.";
        assert AddDriverBerdDay != null : "fx:id=\"AddDriverBerdDay\" was not injected: check your FXML file 'Driver_add.fxml'.";
        assert AddDriversnils != null : "fx:id=\"AddDriversnils\" was not injected: check your FXML file 'Driver_add.fxml'.";
        assert AddDriverINN != null : "fx:id=\"AddDriverINN\" was not injected: check your FXML file 'Driver_add.fxml'.";
        assert AddDriverSeriaDriverCard != null : "fx:id=\"AddDriverSeriaDriverCard\" was not injected: check your FXML file 'Driver_add.fxml'.";
        assert AddDriverNumberDriverCard != null : "fx:id=\"AddDriverNumberDriverCard\" was not injected: check your FXML file 'Driver_add.fxml'.";
        assert add_driver != null : "fx:id=\"add_driver\" was not injected: check your FXML file 'Driver_add.fxml'.";
        assert AddDriverDateDriverCard != null : "fx:id=\"AddDriverDateDriverCard\" was not injected: check your FXML file 'Driver_add.fxml'.";
        assert AddDriverSeriaPassport != null : "fx:id=\"AddDriverSeriaPassport\" was not injected: check your FXML file 'Driver_add.fxml'.";
        assert AddDriverNumberPassport != null : "fx:id=\"AddDriverNumberPassport\" was not injected: check your FXML file 'Driver_add.fxml'.";
        assert AddDriverCodPassport != null : "fx:id=\"AddDriverCodPassport\" was not injected: check your FXML file 'Driver_add.fxml'.";
        assert AddDriverDatePassport != null : "fx:id=\"AddDriverDatePassport\" was not injected: check your FXML file 'Driver_add.fxml'.";
        assert AddDriverWhoPassport != null : "fx:id=\"AddDriverWhoPassport\" was not injected: check your FXML file 'Driver_add.fxml'.";
        assert AddDriverTellNumb1 != null : "fx:id=\"AddDriverTellNumb1\" was not injected: check your FXML file 'Driver_add.fxml'.";
        assert AddDriverTellNumb2 != null : "fx:id=\"AddDriverTellNumb2\" was not injected: check your FXML file 'Driver_add.fxml'.";
        assert regestration != null : "fx:id=\"regestration\" was not injected: check your FXML file 'Driver_add.fxml'.";
        assert retur_btn != null : "fx:id=\"retur_btn\" was not injected: check your FXML file 'Driver_add.fxml'.";

    }
}

package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.ConnectorToMYSQL.Connector;
import sample.DAO;
import sample.TablesClasses.Driver_table;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button New_driver_button;

    @FXML
    private ListView<String> driver_list;

    @FXML
    void initialize() throws SQLException, IOException {
        assert New_driver_button != null : "fx:id=\"New_driver_button\" was not injected: check your FXML file 'sample.fxml'.";
        assert driver_list != null : "fx:id=\"driver_list\" was not injected: check your FXML file 'sample.fxml'.";

        driver_list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        New_driver_button.setOnAction(actionEvent -> {

            //New_driver_button.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/Driver_add.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("Java.png"));
            stage.setTitle("App");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });

        //**** For list of driver in first scene
        // *** Create driver for dao
        Driver_table first_driver = new  Driver_table();
        // *** Create DAO
        DAO first_driver_DAO = new DAO();
        // *** Create connector
        Connector connector = new Connector();
        JdbcConnectionSource connectionSource = new JdbcConnectionSource();
        connectionSource = connector.Connect();
        Dao<Driver_table, Integer> ClassDao = DaoManager.createDao(connectionSource, Driver_table.class);
        ClassDao = first_driver_DAO.ceateDAODriver(connectionSource,first_driver);
        // *** List of driver
       for(Driver_table driiver : ClassDao) {
            driver_list.getItems().addAll(driiver.getDriver_familly() + "\t" + driiver.getDriver_name() + "\t" + driiver.getDriver_otchestvo());
       }

    }
}

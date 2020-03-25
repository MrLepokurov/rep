package sample.Controllers;


import javafx.scene.control.Alert;


public class Notify {

    public void Notify_error(String Error, String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();


            }
}

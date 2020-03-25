package sample.SetGet;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import javafx.application.Platform;
import sample.ConnectorToMYSQL.Connector;
import sample.Controllers.Notify;
import sample.DAO;
import sample.TablesClasses.Driver_table;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class SetDriver implements Runnable {
    String first_name;
    String last_name;
    String father_name;
    Date birthday_dat;
    String driver_snils;
    String driver_inn;
    String driver_sdc;
    String driver_ndc;
    Date driver_ddc_dat;
    String driver_sop;
    String driver_nop;
    String driver_cop;
    Date driver_dop_dat;
    String driver_wop;
    String driver_phone;
    String driver_reg;


    public SetDriver(String first_name, String last_name, String father_name, Date birthday_dat, String driver_snils, String driver_inn, String driver_sdc, String driver_ndc, Date driver_ddc_dat, String driver_sop, String driver_nop, String driver_cop, Date driver_dop_dat, String driver_wop, String driver_phone, String driver_reg) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.father_name = father_name;
        this.birthday_dat = birthday_dat;
        this.driver_snils = driver_snils;
        this.driver_inn = driver_inn;
        this.driver_sdc = driver_sdc;
        this.driver_ndc = driver_ndc;
        this.driver_ddc_dat = driver_ddc_dat;
        this.driver_sop = driver_sop;
        this.driver_nop = driver_nop;
        this.driver_cop = driver_cop;
        this.driver_dop_dat = driver_dop_dat;
        this.driver_wop = driver_wop;
        this.driver_phone = driver_phone;
        this.driver_reg = driver_reg;


    System.out.println("В конструкторе");
    }

    //**********************************************************Create obj Driver from user input
@Override
    public void run() {
        System.out.println("В потоке");
        Notify Error = new Notify();
        String msg = null;
        boolean check;

        if(!(check = SetDriver.checkSTR(first_name))) {
            System.out.println("first_name is " + check);
            msg = "Ошибка в Имени"+ "\n"+"Имя не может быть таким " + first_name;
            String finalMsg = msg;
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
            Error.Notify_error(first_name, finalMsg);
                }
            });
        return;
        }
        if (!(check = SetDriver.checkSTR(last_name))){
            System.out.println("last_name is " + check);
            msg = "Ошибка в Фамилии"+ "\n"+"Фамилия не может быть такой " + last_name;
            String finalMsg = msg;
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Error.Notify_error(last_name, finalMsg);
                }
            });
            return;
        }
        if(!(check = SetDriver.checkSTR(father_name))) {
            System.out.println("father_name is " + check);
            msg = "Ошибка в Отчестве"+ "\n"+"Отчество не может быть таким " + father_name;
            String finalMsg = msg;
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Error.Notify_error(father_name, finalMsg);
                }
            });
            return;
        }
        if(!(check = SetDriver.checkINN(driver_inn))){
            System.out.println("INN is " + check);
            msg = "Ошибка в ИНН"+ "\n"+"ИНН не может быть таким " + driver_inn;
            String finalMsg = msg;
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
            Error.Notify_error(driver_inn, finalMsg);
                }
            });
            return;
        }
        if(!(check = SetDriver.checkSOP(driver_sop))) {
            System.out.println("driver_sop is " + check);
            msg = "Ошибка в Серии паспорта"+ "\n"+"Серия паспорта не может быть такой " + driver_sop;
            String finalMsg = msg;
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Error.Notify_error(driver_sop, finalMsg);
                }
            });
            return;
        }
        if(!(check = SetDriver.checkNOP(driver_nop))) {
            System.out.println("driver_nop is " + check);
            msg = "Ошибка в Номере паспорта"+ "\n"+"Номер паспорта не может быть таким " + driver_nop;
            String finalMsg = msg;
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                Error.Notify_error(driver_nop, finalMsg);
                }
            });
            return;
        }

        Driver_table new_driver = new Driver_table();
        new_driver.setDriver_name(first_name);
        new_driver.setDriver_familly(last_name);
        new_driver.setDriver_otchestvo(father_name);
        new_driver.setDriver_bd(birthday_dat);
        new_driver.setDriver_snils(driver_snils);
        new_driver.setDriver_license_number(driver_sdc);
        new_driver.setDriver_license_date_expirate(driver_ddc_dat);
        new_driver.setDriver_pass_serial(driver_sop);
        new_driver.setDriver_pass_number(driver_nop);
        new_driver.setDriver_pass_code_podr(driver_cop);
        new_driver.setDriver_pass_date(driver_dop_dat);
        new_driver.setDriver_pass_who(driver_wop);
        new_driver.setDriver_phone(driver_phone);
        new_driver.setDriver_registration(driver_reg);
        new_driver.setDriver_inn(driver_inn);

            //*********************************************************Create row in table Driver
            JdbcConnectionSource connectionSource = new JdbcConnectionSource();
            Connector con1 = new Connector();
    try {
        connectionSource = con1.Connect();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    DAO dao = new DAO();
    try {
        dao.create(connectionSource, new_driver);
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }


    return;
        }


    public static boolean checkINN(String INN){
        if(INN.matches("(^(?!0.*$)([0-9]{12})$)|(^(?!0.*$)([0-9]{10})$)")) {
            return true;
        }
        return false;
    }
    public static boolean checkSTR(String str){
        if(str.matches("(^(?!ъ.*$)(?!ь.*$)(?!ы.*$)([а-я]{2,23})$)|(^[А-Я]{1}[а-я]{1,22}$)")) {
            return true;
        }
        return false;
    }
    public static boolean checkSOP(String str){
        if(str.matches("^([0-9]{2}[0-9]{2})?$")) {
            return true;
        }
        return false;
    }

    public static boolean checkNOP(String str){
        if(str.matches("^([0-9]{6})?$")) {
            return true;
        }
        return false;
    }

    }


package sample.SetGet;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import sample.ConnectorToMYSQL.Connector;
import sample.Controllers.Notify;
import sample.DAO;
import sample.TablesClasses.Driver_table;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class SetDriver {


    //**********************************************************Create obj Driver from user input
    public void SetDriver(){

    }

    public static int Set(String first_name, String last_name,
                           String father_name, Date birthday,
                           String driver_snils, String driver_inn,
                           String driver_sdc, String driver_ndc,
                           Date driver_ddc, String driver_sop,
                           String driver_nop, String driver_cop,
                           Date driver_dop, String driver_wop,
                           String driver_phone, String driver_reg) throws IOException, SQLException {
        Notify Error = new Notify();
        String msg = null;
        boolean check;

        if(!(check = SetDriver.checkSTR(first_name))) {
            System.out.println("first_name is " + check);
            msg = "Ошибка в Имени"+ "\n"+"Имя не может быть таким " + first_name;
            Error.Notify_error(first_name, msg);
        return 0;
        }
        if (!(check = SetDriver.checkSTR(last_name))){
            System.out.println("last_name is " + check);
            msg = "Ошибка в Фамилии"+ "\n"+"Фамилия не может быть такой " + last_name;
            Error.Notify_error(last_name, msg);
            return 0;
        }
        if(!(check = SetDriver.checkSTR(father_name))) {
            System.out.println("father_name is " + check);
            msg = "Ошибка в Отчестве"+ "\n"+"Отчество не может быть таким " + father_name;
            Error.Notify_error(father_name, msg);
            return 0;
        }
        if(!(check = SetDriver.checkINN(driver_inn))){
            System.out.println("INN is " + check);
            msg = "Ошибка в ИНН"+ "\n"+"ИНН не может быть таким " + driver_inn;
            Error.Notify_error(driver_inn, msg);
            return 0;
        }
        if(!(check = SetDriver.checkSOP(driver_sop))) {
            System.out.println("driver_sop is " + check);
            msg = "Ошибка в Серии паспорта"+ "\n"+"Серия паспорта не может быть такой " + driver_sop;
            Error.Notify_error(driver_sop, msg);
            return 0;
        }
        if(!(check = SetDriver.checkNOP(driver_nop))) {
            System.out.println("driver_nop is " + check);
            msg = "Ошибка в Номере паспорта"+ "\n"+"Номер паспорта не может быть таким " + driver_nop;
            Error.Notify_error(driver_nop, msg);
            return 0;
        }

        Driver_table new_driver = new Driver_table();
        new_driver.setDriver_name(first_name);
        new_driver.setDriver_familly(last_name);
        new_driver.setDriver_otchestvo(father_name);
        new_driver.setDriver_bd(birthday);
        new_driver.setDriver_snils(driver_snils);
        new_driver.setDriver_license_number(driver_sdc);
        new_driver.setDriver_license_date_expirate(driver_ddc);
        new_driver.setDriver_pass_serial(driver_sop);
        new_driver.setDriver_pass_number(driver_nop);
        new_driver.setDriver_pass_code_podr(driver_cop);
        new_driver.setDriver_pass_date(driver_dop);
        new_driver.setDriver_pass_who(driver_wop);
        new_driver.setDriver_phone(driver_phone);
        new_driver.setDriver_registration(driver_reg);
        new_driver.setDriver_inn(driver_inn);

            //*********************************************************Create row in table Driver
            JdbcConnectionSource connectionSource = new JdbcConnectionSource();
            Connector con1 = new Connector();
            connectionSource = con1.Connect();
            DAO dao = new DAO();
            dao.create(connectionSource, new_driver);


            return 0;
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


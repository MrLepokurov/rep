package sample.TablesClasses;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "driver")
public class Driver_table {

        @DatabaseField (generatedId = true)
        private int iddriver=1;

        @DatabaseField(canBeNull = false)
        private String drive_name;

        @DatabaseField(canBeNull = false)
        private String driver_otchestvo;

        @DatabaseField()
        private String driver_familly;

        @DatabaseField()
        private String driver_license_number;

        @DatabaseField(columnName = "driver_license_date_expirate",
                        dataType = DataType.DATE_STRING,
                        format = "yyyy-MM-dd")
        private Date driver_license_date_expirate;

        @DatabaseField(columnName = "driver_bd",
                        dataType = DataType.DATE_STRING,
                        format = "yyyy-MM-dd")
        private Date driver_bd;

        @DatabaseField()
        private String driver_snils;

        @DatabaseField()
        private String driver_pass_code_podr;

        @DatabaseField()
        private String driver_pass_serial;

        @DatabaseField()
        private String driver_pass_number;

        @DatabaseField(columnName = "driver_pass_date",
                        dataType = DataType.DATE_STRING,
                        format = "yyyy-MM-dd")
        private Date driver_pass_date;

        @DatabaseField()
        private String driver_pass_who;

        @DatabaseField()
        private String driver_inn;

        @DatabaseField()
        private String driver_registration;

        @DatabaseField()
        private String driver_phone;

        @DatabaseField()
        private String driver_wphone;

        @DatabaseField()
        private int driver_ch1_id;

        @DatabaseField()
        private int driver_ch2_id;

        @DatabaseField()
        private int driver_ch3_id;

        @DatabaseField()
        private String driver_owner_company_id;



        public Driver_table(){
        }

        public void setIddriver(int id){
            this.iddriver=id;
        }

        public int getIddriver(){
            return iddriver;
        }

        public void setDriver_name(String name){
            this.drive_name = name;
        }

        public String getDriver_name(){
            return drive_name;
        }

        public void setDriver_otchestvo(String otchestvo){
            this.driver_otchestvo = otchestvo;
        }

        public String getDriver_otchestvo(){
            return driver_otchestvo;
        }

        public void setDriver_familly(String familly){
            this.driver_familly = familly;
        }

        public String getDriver_familly(){
            return driver_familly;
        }

        public void setDriver_license_number(String license){
            this.driver_license_number = license;
        }

        public String getDriver_license_number(){
            return driver_license_number;
        }

        public void setDriver_license_date_expirate(Date date){
            this.driver_license_date_expirate = date;
        }

        public Date getDriver_license_date_expirate(){
            return driver_license_date_expirate;
        }

        public void setDriver_bd(Date datebd){
            this.driver_bd = datebd;
        }

        public Date getDriver_bd(){
            return driver_bd;
        }

        public void setDriver_snils(String snilsn){
            this.driver_snils = snilsn;
        }

        public String getDriver_snils(){
            return driver_snils;
        }

        public void setDriver_pass_code_podr(String pass_code){
            this.driver_pass_code_podr = pass_code;
        }

        public String getDriver_pass_code_podr(){
            return driver_pass_code_podr;
        }

        public void setDriver_pass_serial(String seria){
            this.driver_pass_serial = seria;
        }

        public String getDriver_pass_serial(){
            return driver_pass_serial;
        }

    public String getDriver_pass_number() {
        return driver_pass_number;
    }

    public void setDriver_pass_number(String driver_pass_number) {
        this.driver_pass_number = driver_pass_number;
    }

    public Date getDriver_pass_date() {
        return driver_pass_date;
    }

    public void setDriver_pass_date(Date driver_pass_date) {
        this.driver_pass_date = driver_pass_date;
    }

    public String getDriver_pass_who() {
        return driver_pass_who;
    }

    public void setDriver_pass_who(String driver_pass_who) {
        this.driver_pass_who = driver_pass_who;
    }

    public String getDriver_inn() {
        return driver_inn;
    }

    public void setDriver_inn(String driver_inn) {
        this.driver_inn = driver_inn;
    }

    public String getDriver_registration() {
        return driver_registration;
    }

    public void setDriver_registration(String driver_registration) {
        this.driver_registration = driver_registration;
    }

    public String getDriver_phone() {
        return driver_phone;
    }

    public void setDriver_phone(String driver_phone) {
        this.driver_phone = driver_phone;
    }

    public String getDriver_wphone() {
        return driver_wphone;
    }

    public void setDriver_wphone(String driver_wphone) {
        this.driver_wphone = driver_wphone;
    }

    public String getDriver_owner_company_id() {
        return driver_owner_company_id;
    }

    public void setDriver_owner_company_id(String driver_owner_company_id) {
        this.driver_owner_company_id = driver_owner_company_id;
    }


            }


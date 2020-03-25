package sample;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import java.io.IOException;
import java.sql.SQLException;

import sample.ConnectorToMYSQL.Connector;
import sample.TablesClasses.Driver_table;



public class DAO {
    public DAO(){
     }
    public void create(JdbcConnectionSource connectionSource, Driver_table driver) throws SQLException,IOException{
        Dao<Driver_table, Integer> ClassDao = DaoManager.createDao(connectionSource , Driver_table.class);
        ClassDao.create(driver);
        for(Driver_table driver1 : ClassDao) {
            System.out.println(driver1.getDriver_familly() + "\t" + driver1.getDriver_name() + "\t" + driver1.getDriver_otchestvo());
        }
    }

    public static Dao<Driver_table, Integer> ceateDAODriver(JdbcConnectionSource connectionSource, Driver_table driver) throws SQLException,IOException {
        Dao<Driver_table, Integer> ClassDao = DaoManager.createDao(connectionSource, Driver_table.class);
        return ClassDao;
        }

    public static void findeDriver(int id) throws SQLException, IOException {
        JdbcConnectionSource connectionSource = new JdbcConnectionSource();
        Connector con1 = new Connector();
        connectionSource = con1.Connect();
        Driver_table driver = new  Driver_table();
        Dao<Driver_table, Integer> ClassDao = DaoManager.createDao(connectionSource , Driver_table.class);
        for(Driver_table driver1 : ClassDao) {
            if (id == driver1.getIddriver()) {
                System.out.println(driver1.getDriver_familly() + "\t" + driver1.getDriver_name() + "\t" + driver1.getDriver_otchestvo());
            }
            System.out.println("\t"+id+"\t"+driver1.getIddriver());
        }
    }

}

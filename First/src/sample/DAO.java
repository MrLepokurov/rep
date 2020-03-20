package sample;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import java.io.IOException;
import java.sql.SQLException;
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

}

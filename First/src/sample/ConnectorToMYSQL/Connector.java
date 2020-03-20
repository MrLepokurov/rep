package sample.ConnectorToMYSQL;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import java.io.IOException;
import java.sql.SQLException;


public class Connector {

    public static JdbcConnectionSource Connect() throws SQLException, IOException {
        final String databaseUrl = ("jdbc:mysql://localhost:3306/mydb?useUnicode=true&serverTimezone=UTC");
        final JdbcConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl, "wialon", "Fkfj$9302!");
        return connectionSource;
        //System.out.println("Set");
       //Dao<Account, Integer> AccountDao
          //     = DaoManager.createDao(connectionSource, Account.class);

       //  Account account = new Account();
       //  account.setID(0);
       //  account.setPassword("sdsfsd");

     //   AccountDao.update(account);

       // Account account2 = AccountDao.queryForId(11);
       // System.out.println("Account: " + account2.getID());
       // connectionSource.close();
    }



}

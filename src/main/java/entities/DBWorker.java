package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by imac on 25.11.16.
 */
public class DBWorker {

    private static volatile DBWorker instance = null;

    public static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/imac";

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    private DBWorker() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DATABASE_URL);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBWorker getInstance() {
        if(instance == null){
            synchronized (DBWorker.class) {
                if (instance == null)
                    instance = new DBWorker();
            }
        }
        return instance;
    }
}

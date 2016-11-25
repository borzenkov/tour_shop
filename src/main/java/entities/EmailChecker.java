package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmailChecker {

    public static boolean emailExists(String email) {
        try {
            PreparedStatement preparedStatement = DBWorker.getInstance().getConnection().prepareStatement("select count(*) as total from users where email=?");
            preparedStatement.setString(1, email);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            int total = result.getInt("total");
            if (total > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

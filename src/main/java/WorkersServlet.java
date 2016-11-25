import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

/**
 * Created by imac on 22.11.16.
 */
public class WorkersServlet extends HttpServlet {

    public static final String PREPARED_INSERT_QUERY = "insert into workers (name, last_name) values (?, ?)";
    public static final String SELECT_QUERY = "SELECT * FROM WORKERS;";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Connection connection = null;
        OutputStream os = response.getOutputStream();

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/imac");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY);
            os.write("<html><body>".getBytes());
            while (resultSet.next()) {
                //System.out.println( resultSet.getString(2) + " " + resultSet.getString(3) );
                os.write((resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + "<br>").getBytes());
            }
            os.write("</body></html>".getBytes());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

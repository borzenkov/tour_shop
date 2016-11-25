import entities.DBWorker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by imac on 25.11.16.
 */
@WebServlet("/editProfile")
public class EditProfileServlet extends HttpServlet {

    public static final String PREPARED_UPDATE_QUERY = "UPDATE users SET name = ? where email = ?";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getSession().getAttribute("email").toString();

        PreparedStatement statement = null;
        try {
            statement = DBWorker.getInstance().getConnection().prepareStatement(PREPARED_UPDATE_QUERY);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

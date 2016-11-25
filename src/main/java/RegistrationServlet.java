import entities.DBWorker;
import entities.EmailChecker;
import entities.EmailValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

import static entities.PasswordValidator.validatePassword;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    public static final String PREPARED_INSERT_QUERY = "insert into users (email, password) values (?, ?)";

    private DBWorker dbWorker = DBWorker.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean isEmailValid = EmailValidator.isValid(email);
        if (isEmailValid) {
            boolean emailExists = EmailChecker.emailExists(email);
            if (!emailExists) {
                boolean isPasswordValid = validatePassword(password);
                if (isPasswordValid) {
                    addUser(email, password);
                    request.setAttribute("message", "Вы зарегистрированы.");
                    getServletContext().getRequestDispatcher("/registrationResult.jsp")
                            .forward(request, response);
                } else {
                    request.setAttribute("message", "Плохой пароль.");
                    getServletContext().getRequestDispatcher("/registrationResult.jsp")
                            .forward(request, response);
                }
            } else {
                request.setAttribute("message", "Пользователь с таким  email уже зарегистрирован.");
                getServletContext().getRequestDispatcher("/registrationResult.jsp")
                        .forward(request, response);
            }

        } else {
            request.setAttribute("message", "Плохой  email.");
            getServletContext().getRequestDispatcher("/registrationResult.jsp")
                    .forward(request, response);
        }
    }


    private void addUser(String email, String password) {
        try {
            PreparedStatement statement = dbWorker.getConnection().prepareStatement(PREPARED_INSERT_QUERY);
            statement.setString(1, email);
            statement.setString(2, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
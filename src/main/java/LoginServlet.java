import entities.EmailValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static entities.EmailChecker.emailExists;
import static entities.PasswordChecker.isPasswordCorrect;

/**
 * Created by imac on 20.11.16.
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean isEmailValid = EmailValidator.isValid(email);
        if (isEmailValid) {
            boolean emailExists = emailExists(email);
            if (emailExists) {
                boolean isPasswordCorrect = isPasswordCorrect(email, password);
                if (isPasswordCorrect) {
                    request.getSession().setAttribute("email", email);
                    response.sendRedirect("/profile.jsp");
                } else {
                    request.setAttribute("message", "Плохой логин и/или пароль.");
                    getServletContext().getRequestDispatcher("/loginResult.jsp")
                            .forward(request, response);
                }
            } else {
                request.setAttribute("message", "Плохой логин и/или пароль.");
                getServletContext().getRequestDispatcher("/loginResult.jsp")
                        .forward(request, response);
            }
        } else {
            request.setAttribute("message", "Плохой логин и/или пароль.");
            getServletContext().getRequestDispatcher("/loginResult.jsp")
                    .forward(request, response);
        }

    }
}

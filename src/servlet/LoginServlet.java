package servlet;
import entities.*;
import service.UserService;
import service.UserServiceImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String username = request.getParameter("username");
        final String password = request.getParameter("password");

        UserService userService = new UserServiceImpl();
        User user = new User();
        boolean isConnected;
        isConnected =  userService.login(username,password);
        if (isConnected){
           
            HttpSession session = request.getSession();
            session.setAttribute("user",user) ;
            response.sendRedirect("/home");
        } else {
            request.setAttribute("errorMessage","login ou mot de passe invalide");
            System.out.println("incorrect");
            doGet(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/homea").forward(request, response);
    }
}

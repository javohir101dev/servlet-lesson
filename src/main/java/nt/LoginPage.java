package nt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@WebServlet("/login")
public class LoginPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("Login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> userList = new ArrayList<>(Arrays.asList(
                new User("user", "123"),
                new User("aja101dev", "456")
        ));

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter writer = resp.getWriter();

        boolean exists = false;
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                exists = true;
            }
        }
        if (exists){
            writer.write("Welcome to our system");
        }else {
          writer.write("Login or password wrong");}
    }
}

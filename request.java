package com.bankingsystem.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserDisplayServlet", urlPatterns = "/UserDisplayServlet")
public class UserDisplayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create mock data for users
        List<User> users = new ArrayList<>();
        users.add(new User("Hasrh", "Hrsh@example.com"));
        users.add(new User("Harsh_raj", "jerr.doe@example.com"));
        users.add(new User("Akka", "akka@example.com"));

        // Set users as a request attribute
        request.setAttribute("userList", users);

        // Forward to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("displayUsers.jsp");
        dispatcher.forward(request, response);
    }
}

// Create a User class for holding user details
class User {
    private String username;
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}

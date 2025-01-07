package com.bankingsystem.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    // In-memory storage for registered users
    private Map<String, String[]> users = new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get user details from the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // Check if the username is already registered
        if (users.containsKey(username)) {
            response.setContentType("text/html");
            response.getWriter().println("<h1 style='color: red;'>Username already exists!</h1>");
            response.getWriter().println("<a href='register.jsp'>Go Back</a>");
            return;
        }

        // Store user details
        users.put(username, new String[]{password, email});

        // Redirect to profile page
        response.sendRedirect("profile?username=" + username);
    }

    // Helper method to retrieve users (for use in other servlets)
    public Map<String, String[]> getUsers() {
        return users;
    }
}

package com.bankingsystem.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ProfileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get username from query parameter
        String username = request.getParameter("username");

        // Access the RegistrationServlet's users map
        RegistrationServlet registrationServlet = (RegistrationServlet) getServletContext().getAttribute("registrationServlet");
        Map<String, String[]> users = registrationServlet.getUsers();

        // Check if the user exists
        if (username == null || !users.containsKey(username)) {
            response.setContentType("text/html");
            response.getWriter().println("<h1 style='color: red;'>User not found!</h1>");
            response.getWriter().println("<a href='register.jsp'>Register Here</a>");
            return;
        }

        // Get user details
        String[] userDetails = users.get(username);
        String email = userDetails[1];

        // Display profile
        response.setContentType("text/html");
        response.getWriter().println("<h1>Banking System - User Profile</h1>");
        response.getWriter().println("<p><strong>Username:</strong> " + username + "</p>");
        response.getWriter().println("<p><strong>Email:</strong> " + email + "</p>");
        response.getWriter().println("<a href='register.jsp'>Register Another User</a>");
    }
}

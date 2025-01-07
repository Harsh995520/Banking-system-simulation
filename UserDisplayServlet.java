package com.bankingsystem.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserDisplayServlet", urlPatterns = "/UserDisplayServlet")
public class UserDisplayServlet extends HttpServlet {

    private static final Map<String, String[]> users = new HashMap<>();

    static {
        // Adding some mock data (username, password, email)
        users.put("Harsh", new String[]{"password123", "Harsh.doe@example.com"});
        users.put("Harsh_raj", new String[]{"password456", "raj.doe@example.com"});
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set user data as a request attribute
        request.setAttribute("users", users);

        // Forward to the JSP page for display
        RequestDispatcher dispatcher = request.getRequestDispatcher("displayUsers.jsp");
        dispatcher.forward(request, response);
    }
}

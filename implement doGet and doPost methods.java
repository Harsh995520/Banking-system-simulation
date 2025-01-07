package com.bankingsystem.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BankingServlet", urlPatterns = "/banking")
public class BankingServlet extends HttpServlet {

    // Sample data for demonstration
    private String accountHolderName = "John Doe";
    private double accountBalance = 1000.0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Display account details
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Banking Management System</h1>");
            out.println("<h2>Account Details:</h2>");
            out.println("<p><strong>Account Holder:</strong> " + accountHolderName + "</p>");
            out.println("<p><strong>Account Balance:</strong> $" + accountBalance + "</p>");
            out.println("<br>");
            out.println("<form method='POST' action='/banking'>");
            out.println("<label for='transactionType'>Transaction Type:</label>");
            out.println("<select name='transactionType' id='transactionType'>");
            out.println("<option value='deposit'>Deposit</option>");
            out.println("<option value='withdraw'>Withdraw</option>");
            out.println("</select>");
            out.println("<br><label for='amount'>Amount:</label>");
            out.println("<input type='number' name='amount' id='amount' required>");
            out.println("<br><button type='submit'>Submit</button>");
            out.println("</form>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Retrieve form data
        String transactionType = request.getParameter("transactionType");
        String amountStr = request.getParameter("amount");

        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Banking Management System</h1>");
            out.println("<h2>Transaction Summary:</h2>");

            // Validate and process the transaction
            try {
                double amount = Double.parseDouble(amountStr);

                if ("deposit".equalsIgnoreCase(transactionType)) {
                    accountBalance += amount;
                    out.println("<p><strong>Transaction:</strong> Deposit</p>");
                } else if ("withdraw".equalsIgnoreCase(transactionType)) {
                    if (amount > accountBalance) {
                        out.println("<p style='color: red;'>Error: Insufficient balance!</p>");
                        out.println("<p><strong>Current Balance:</strong> $" + accountBalance + "</p>");
                        return;
                    }
                    accountBalance -= amount;
                    out.println("<p><strong>Transaction:</strong> Withdrawal</p>");
                } else {
                    out.println("<p style='color: red;'>Invalid transaction type.</p>");
                    return;
                }

                // Display updated balance
                out.println("<p><strong>Transaction Amount:</strong> $" + amount + "</p>");
                out.println("<p><strong>Updated Balance:</strong> $" + accountBalance + "</p>");
            } catch (NumberFormatException e) {
                out.println("<p style='color: red;'>Invalid amount entered. Please enter a numeric value.</p>");
            }

            // Back to account overview
            out.println("<br><a href='/banking'>Go Back to Account Overview</a>");
        }
    }
}

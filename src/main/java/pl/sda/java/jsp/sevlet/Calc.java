package pl.sda.java.jsp.sevlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Calc extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        if(request.getSession().getAttribute("email") != null){

            Calculator calculator = (Calculator) request.getSession().getAttribute("calculator");
            if (calculator == null) {
                calculator = new Calculator();
                request.getSession().setAttribute("calculator", calculator);
            }

            if (request.getParameter("arg") != null) {
                calculator.input(request.getParameter("arg"));
            }

            request.getRequestDispatcher("kalkulator.jsp").forward(request, response);
        }else {
            response.sendRedirect("email");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Calculator calculator = (Calculator) req.getSession().getAttribute("calculator");

        if ("CE".equals(req.getParameter("ce"))) {
            calculator.clear();
        }
        if ("+".equals(req.getParameter("operator"))) {
            calculator.add();
        }
        if ("-".equals(req.getParameter("operator"))) {
            calculator.substract();
        }
        if ("=".equals(req.getParameter("evaluate"))) {
            calculator.evaluate();
        }

        req.getRequestDispatcher("kalkulator.jsp").forward(req, resp);
    }
}
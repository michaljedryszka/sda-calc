package pl.sda.java.jsp.sevlet;

import pl.sda.java.jsp.sevlet.model.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "calc", urlPatterns = "/calc")
public class Calc extends HttpServlet {

    private Calculator calculator = new Calculator();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        if (Objects.nonNull(request.getParameter("arg"))) {
            calculator.input(request.getParameter("arg"));
        }
        printForm(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (Objects.nonNull(request.getParameter("operator"))) {
            calculator.operator(request.getParameter("operator"));
        } else if ("CE".equals(request.getParameter("ce"))) {
            calculator.reset();
        } else if ("=".equals(request.getParameter("evaluate"))) {
            calculator.calculate();
        }
        printForm(request, response);
    }

    private void printForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("display", calculator.display());
        request.getRequestDispatcher("WEB-INF/jsp/kalkulator.jsp")
                .forward(request, response);
    }
}
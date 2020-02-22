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

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        if (Objects.nonNull(request.getParameter("arg"))) {
            calculator(request).input(request.getParameter("arg"));
        }
        printForm(request, response);
    }

    private Calculator calculator(HttpServletRequest request){
        Calculator calculator = (Calculator) request.getSession().getAttribute("calculator");
        if(Objects.isNull(calculator)){
            calculator = new Calculator();
            request.getSession().setAttribute("calculator", calculator);
        }
        return calculator;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (Objects.nonNull(request.getParameter("operator"))) {
            calculator(request).operator(request.getParameter("operator"));
        } else if ("CE".equals(request.getParameter("ce"))) {
            calculator(request).reset();
        } else if ("=".equals(request.getParameter("evaluate"))) {
            calculator(request).calculate();
        }
        printForm(request, response);
    }

    private void printForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("display", calculator(request).display());
        request.getRequestDispatcher("WEB-INF/jsp/kalkulator.jsp")
                .forward(request, response);
    }
}
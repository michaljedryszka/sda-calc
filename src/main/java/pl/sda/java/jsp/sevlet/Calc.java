package pl.sda.java.jsp.sevlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "calc", urlPatterns = "/calc")
public class Calc extends HttpServlet {

    private String operandA = "";
    private String operandB = "";
    private String operator = "";

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        if (Objects.nonNull(request.getParameter("arg"))) {
            if (operator.isEmpty()) {
                operandA += request.getParameter("arg");
            } else {
                operandB += request.getParameter("arg");
            }
        }
        printForm(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if ("+".equals(request.getParameter("operator"))) {
            operator = "+";
            if(!operandB.isEmpty()){
                operandA = "" + (Integer.valueOf(operandA)
                        + Integer.valueOf(operandB));
                operandB = "";
            }
        } else if ("CE".equals(request.getParameter("ce"))) {
            operandA = "";
            operandB = "";
            operator = "";
        } else if ("=".equals(request.getParameter("evaluate"))) {
            if(operator.equals("+")){
                if(!operandB.isEmpty()) {
                    operandA = "" + (Integer.valueOf(operandA)
                            + Integer.valueOf(operandB));
                }
                operandB = "";
                operator = "";
            }
        }
        printForm(request, response);
    }

    private void printForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("display", display());
        request.getRequestDispatcher("WEB-INF/jsp/kalkulator.jsp")
                .forward(request, response);
    }

    private String display() {
        return operandA + operator + operandB;
    }
}
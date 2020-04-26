package pl.sda.java.jsp.sevlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Calc extends HttpServlet {

    private String input = "";

    private String input2 = "";

    private String operator;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("arg") != null) {
            input = input + request.getParameter("arg");
        }

        request.setAttribute("output", input);

        request.getRequestDispatcher("kalkulator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("CE".equals(req.getParameter("ce"))) {
            input = "";
        }
        if ("+".equals(req.getParameter("operator"))) {
            input2 = input;
            input = "";
            operator = "+";
        }
        if ("-".equals(req.getParameter("operator"))) {
            input2 = input;
            input = "";
            operator = "-";
        }
        if ("=".equals(req.getParameter("evaluate"))) {
            if("+".equals(operator)){
                input = String.valueOf(Integer.valueOf(input) + Integer.valueOf(input2));
            }
            if("-".equals(operator)){
                input = String.valueOf(Integer.valueOf(input2) - Integer.valueOf(input));
            }
        }
        req.setAttribute("output", input);
        req.getRequestDispatcher("kalkulator.jsp").forward(req, resp);
    }

    public static void main(String[] args) {
        String s1 = new String("a");
        String s2 = "a";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
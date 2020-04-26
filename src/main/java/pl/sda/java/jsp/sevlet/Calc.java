package pl.sda.java.jsp.sevlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Calc extends HttpServlet {

    /*
        private String input = "";

        private String input2 = "";

        private String operator;
    */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        String input = (String) request.getSession().getAttribute("input");
        if (input == null) {
            input = "";
        }

        if (request.getParameter("arg") != null) {
            input = input + request.getParameter("arg");

            request.getSession().setAttribute("input", input);
        }

        request.setAttribute("output", input);

        request.getRequestDispatcher("kalkulator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String input = (String) req.getSession().getAttribute("input");
        String input2 = (String) req.getSession().getAttribute("input2");
        String operator = (String) req.getSession().getAttribute("operator");

        if ("CE".equals(req.getParameter("ce"))) {
            input = "";
        }
        if ("+".equals(req.getParameter("operator"))) {
            input2 = input;
            input = "";
            operator = "+";
            req.getSession().setAttribute("input2", input2);
            req.getSession().setAttribute("operator", operator);
        }
        if ("-".equals(req.getParameter("operator"))) {
            input2 = input;
            input = "";
            operator = "-";
            req.getSession().setAttribute("input2", input2);
            req.getSession().setAttribute("operator", operator);
        }
        if ("=".equals(req.getParameter("evaluate"))) {
            if ("+".equals(operator)) {
                input = String.valueOf(Integer.valueOf(input) + Integer.valueOf(input2));
            }
            if ("-".equals(operator)) {
                input = String.valueOf(Integer.valueOf(input2) - Integer.valueOf(input));
            }
        }
        req.getSession().setAttribute("input", input);

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
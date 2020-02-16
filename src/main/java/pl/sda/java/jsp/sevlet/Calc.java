package pl.sda.java.jsp.sevlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "calc", urlPatterns = "/calc")
public class Calc extends HttpServlet {

    private String display = "";

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        if (Objects.nonNull(request.getParameter("arg"))) {
            display += request.getParameter("arg");
        }

        request.setAttribute("display", display);

        request.getRequestDispatcher("WEB-INF/jsp/kalkulator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        display = "";
        request.setAttribute("display", display);
        request.getRequestDispatcher("WEB-INF/jsp/kalkulator.jsp")
                .forward(request, response);
    }
}
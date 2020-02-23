package pl.sda.java.jsp.sevlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "test", urlPatterns = "/test")
public class TestServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(Objects.isNull(req.getSession().getAttribute("email"))){
            resp.sendRedirect("/calc/email");
        } else {
            resp.getWriter().write("Test");
        }
    }
}

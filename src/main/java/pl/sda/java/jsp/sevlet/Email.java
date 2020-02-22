package pl.sda.java.jsp.sevlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "email", urlPatterns = "/email")
public class Email extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/email.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        if(Objects.nonNull(email) && !email.isEmpty()){
            req.getSession().setAttribute("email", req.getParameter("email"));
            resp.sendRedirect("/calc/calc");
        }else{
            req.getRequestDispatcher("/WEB-INF/jsp/email.jsp")
                    .forward(req, resp);
        }
    }
}

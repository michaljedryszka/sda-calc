package pl.sda.java.jsp.sevlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "*")
public class EmailFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Email filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getServletPath().equals("/email")
                || request.getSession().getAttribute("email") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect("email");
        }
    }

    @Override
    public void destroy() {
        System.out.println("Email filter destroy");
    }
}

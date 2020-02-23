package pl.sda.java.jsp.sevlet;


import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebFilter(displayName = "EmailFilter", urlPatterns = "/*")
public class EmailFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if(request.getServletPath().equals("/email")){
            filterChain.doFilter(servletRequest, servletResponse);
        } else if(Objects.isNull(request.getSession().getAttribute("email"))) {
            response.sendRedirect("/calc/email");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}

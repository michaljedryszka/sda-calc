package pl.sda.java.jsp.sevlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Homework extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer rozmiar = Integer.valueOf(req.getParameter("rozmiar"));

        String znak = "x";
        for(int i = 0; i < rozmiar; i ++){
            for(int j = 0; j <= i; j ++) {
                resp.getWriter().print(znak);
                if(znak == "x"){
                    znak = "o";
                } else {
                    znak = "x";
                }
            }
            resp.getWriter().print("\n");
        }
    }

    public static void main(String[] args) {
        int rozmiar = 4;
        String znak = "x";
        for(int i = 0; i < rozmiar; i ++){
            for(int j = 0; j <= i; j ++) {
                System.out.print(znak);
                if(znak == "x"){
                    znak = "o";
                } else {
                    znak = "x";
                }
            }
            System.out.println();
        }
    }

    /**
     *     if (k % 2 == 0) {
     *         out.print("x");
     *     }
     *     if (k % 2 == 1) {
     *         out.print("o");
     *     }
     */
}

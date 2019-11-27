package pl.n2god;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author n2god on 27/11/2019
 * @project SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession();
        PrintWriter writer = response.getWriter();
        writer.write("Test sesji!");
    }
}

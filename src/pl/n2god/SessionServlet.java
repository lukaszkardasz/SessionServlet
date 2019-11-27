package pl.n2god;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author n2god on 27/11/2019
 * @project SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(20);
        User user = (User) session.getAttribute("user");
        if (user == null){
            user = createUser(request);
            if (user != null){
                session.setAttribute("user", user);
            }
            sendResponse(response, user);
        }
    }

    private User createUser(HttpServletRequest request) {
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        if (firstName == null || lastName == null){
            return null;
        } else return new User(firstName, lastName);
    }

    private void sendResponse(HttpServletResponse response, User user) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("  <body>");
        writer.println("<h1>Test Sesji</h1>");
        if (user != null && user.getFirstName() != null && user.getLastName() != null){
            writer.println("<div>Witaj " + user.getFirstName() + " " + user.getLastName() + "</div>");
        } else {
            writer.println("<div>Witaj nieznajomy!</div>");
        }
        writer.println("  </body>");
        writer.println("</html>");
    }
}

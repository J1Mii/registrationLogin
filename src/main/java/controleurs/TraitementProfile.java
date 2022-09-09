package controleurs;

import entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class TraitementProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        if(user != null) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/profile.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

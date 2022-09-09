package controleurs;

import dao.UserDao;
import entities.User;
import utils.PasswordUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


public class TraitementLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("passwd");

        PasswordUtils passwordUtils = new PasswordUtils();
        UserDao userDao = new UserDao();

        if(userDao.doExist(username)){
            User user = userDao.find(username);
            if(user != null) {
                String salt = user.getSalt();
                String hashPassword = user.getHashPassword();

                boolean passwordCorrect = passwordUtils.verify( password, hashPassword, salt);

                if(passwordCorrect) {
                    request.getSession().setAttribute("user", user);

                    response.sendRedirect("index.jsp");
                } else {
                    response.sendRedirect("login.jsp");
                }
            } else {
                response.sendRedirect("login.jsp");
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}

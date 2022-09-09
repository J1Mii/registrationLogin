package controleurs;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.UserDao;
import entities.User;
import utils.PasswordUtils;

import java.io.IOException;

public class TraitementRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("passwd");
        String confirmPassword = request.getParameter("cpasswd");
        UserDao userDao = new UserDao();

        if(password.equals(confirmPassword)){
            if(!(userDao.doExist(username))){
                PasswordUtils passwordUtil = new PasswordUtils();
                passwordUtil.hash(password);
                String hashPass = passwordUtil.getHashpassword();
                String salt = passwordUtil.getSalt();

                User user = new User(username,hashPass,salt);
                userDao.save(user);

                request.getSession().setAttribute("user", user);

                response.sendRedirect("index.jsp");
            } else{
                response.sendRedirect("register.jsp");
            }
        } else {
            response.sendRedirect("register.jsp");
        }

    }
}

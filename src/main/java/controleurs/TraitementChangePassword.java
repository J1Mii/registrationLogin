package controleurs;

import dao.UserDao;
import entities.User;
import utils.PasswordUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class TraitementChangePassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PasswordUtils passwordUtil = new PasswordUtils();
        String oldpasswd = request.getParameter("oldpasswd");
        String password = request.getParameter("passwd");
        String confirmPassword = request.getParameter("cpasswd");
        UserDao userDao = new UserDao();
        User user = (User) request.getSession().getAttribute("user");


        if(password.equals(confirmPassword)){
            if(user != null){
                String oldHashPass = user.getHashPassword();
                String oldSalt = user.getSalt();

                boolean passwordCorrect = passwordUtil.verify(oldpasswd, oldHashPass, oldSalt);


                if(passwordCorrect) {
                    passwordUtil.hash(password);
                    String hashPass = passwordUtil.getHashpassword();
                    String salt = passwordUtil.getSalt();

                    userDao.updatePassword(user, hashPass, salt);

                    request.getSession().invalidate();
                    response.sendRedirect("index.jsp");
                } else {
                    response.sendRedirect("profile.jsp");
                }
            } else{
                response.sendRedirect("profile.jsp");
            }
        } else {
            request.getSession().invalidate();
            response.sendRedirect("profile.jsp");
        }
    }
}


/*
request.setAttribute("test", passwordCorrect);
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/test.jsp");
                requestDispatcher.forward(request, response);
 */

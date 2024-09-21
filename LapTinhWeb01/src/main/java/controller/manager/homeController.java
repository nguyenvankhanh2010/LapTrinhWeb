package controller.manager;

import java.io.IOException;

import constant.Constant;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.UserModel;
import service.IUserService;
import service.impl.UserService;
@WebServlet(urlPatterns = {"/home"})

public class homeController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  Cookie[] cookies = req.getCookies();
	        if (cookies != null)
	        {
	            for (Cookie cookie : cookies)
	            {
	                if (cookie.getName().equals("username"))
	                {
	                    IUserService service = new UserService();
	                    UserModel user = service.get(cookie.getValue());
	                    // If found user, create a session and save information to the session
	                    if (user != null)
	                    {
	                        HttpSession session = req.getSession(true);
	                        session.setAttribute("account", user);
	                    }
	                }
	            }
	        }
	        RequestDispatcher requestDispatcher = req.getRequestDispatcher(Constant.Path.MANAGER_HOME);
	        requestDispatcher.forward(req, resp);

}
}

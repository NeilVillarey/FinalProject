// AYUSIN!!! 
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CryptoUtil;
import model.User;
import model.RegisterJdbc;
import nl.captcha.Captcha;

/**
 * Servlet implementation class Register
 */
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        password = CryptoUtil.encrypt(password);

        User user = new User();
        user.setFullname(fullname);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);

        RegisterJdbc rJdbc = new RegisterJdbc();
        String userRegistered = rJdbc.registerUser(user);
        HttpSession session = request.getSession();
        Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
        request.setCharacterEncoding("UTF-8");
        String answer = request.getParameter("answer");
        if (captcha.isCorrect(answer)) {
            
            if (userRegistered.equals("SUCCESS")) {
                session = request.getSession();
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                request.setAttribute("errMessage", userRegistered);
                request.getRequestDispatcher("registration.jsp").forward(request, response);
            }

        }
    }
}

//AYUSIN!!!! 
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CryptoUtil;
import model.LoginJdbc;
import model.LoginUser;
import nl.captcha.Captcha;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//                
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginJdbc loginJdbc = new LoginJdbc();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        password = CryptoUtil.encrypt(password);
        LoginUser loginUser = new LoginUser();

        loginUser.setUsername(username);
        loginUser.setPassword(password);
        HttpSession session = request.getSession();
        Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
        request.setCharacterEncoding("UTF-8");
        String answer = request.getParameter("answer");
        if (captcha.isCorrect(answer)) {
            try {
                String userValidate = loginJdbc.authenticateUser(loginUser);

                if (userValidate.equals("Admin_Role")) {
                    System.out.println("Admin's Home");

                    session = request.getSession(); //Creating a session
                    session.setAttribute("ADMIN", username); //setting session attribute
                    request.setAttribute("username", username);
                    session.setAttribute("username", username);
                    request.getRequestDispatcher("adminpage.jsp").forward(request, response);
                } else if (userValidate.equals("Member_Role")) {
                    System.out.println("Member's Home");

                    session = request.getSession();
                    session.setAttribute("MEMBER", username);
                    request.setAttribute("username", username);
                    session.setAttribute("username", username);
                    request.getRequestDispatcher("memberpage.jsp").forward(request, response);
                } else if (userValidate.equals("Guest_Role")) {
                    System.out.println("Guest's Home");

                    session = request.getSession();
                    session.setMaxInactiveInterval(10 * 60);
                    session.setAttribute("GUEST", username);
                    request.setAttribute("username", username);
                    session.setAttribute("username", username);
                    request.getRequestDispatcher("guestpage.jsp").forward(request, response);
                } else {
                    System.out.println("Error message = " + userValidate);
                    request.setAttribute("errMessage", userValidate);

                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }
    }
}

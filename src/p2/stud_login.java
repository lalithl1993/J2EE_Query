package p2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import p2.Validate2;

public class stud_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

			response.setContentType("text/html;");
	        PrintWriter out = response.getWriter();
			String un=request.getParameter("stusername");
			String pw=request.getParameter("stpass");
			if(Validate2.checkUser(un, pw))
	        {
				System.out.print("student logout processing, "+un);
				HttpSession session=request.getSession(true);  
		        session.setAttribute("stusername",un);
	            RequestDispatcher rs = request.getRequestDispatcher("St_Welcome");
	            rs.forward(request, response);
	        }
	        else
	        {
	           out.println("Username or Password incorrect");
	           RequestDispatcher rs = request.getRequestDispatcher("stud_login.jsp");
	           rs.include(request, response);
	        }
		}
	}


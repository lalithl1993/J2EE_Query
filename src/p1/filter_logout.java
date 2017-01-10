package p1;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.*;


public class filter_logout implements Filter {

    /**
     * Default constructor. 
     */
    public filter_logout() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		PrintWriter out= response.getWriter();
		String sess= request.getParameter("sess");
		//String sess="user";
		System.out.println("in");
		chain.doFilter(request, response);
		System.out.println("out");
		out.println("<body>"); 
		if(Objects.equals(sess,"stusername"))
		{
			out.println("student logged out");

	        out.println("<a href='stud_login.jsp'>login again</a>");
		}
		else  if(Objects.equals(sess,"trusername"))
		{
			out.println("teacher logged out");
	        out.println("<a href='tr_login.jsp'>login again</a>");
		}
		
		out.println("</body>"); 
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

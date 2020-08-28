package com.iiht.evaluation.coronakit.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminAuthenticationFilter
 */
@WebFilter("/admin/*")
public class AdminAuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminAuthenticationFilter() {
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
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chainObj) throws IOException, ServletException {
		 
        RequestDispatcher rdObj = null;
        PrintWriter out = resp.getWriter();
        out.write("<html><body><div id='servletResponse' style='text-align: center;'>");
        
        String user = req.getParameter("loginid");
        String password = req.getParameter("password");
        System.out.println("user Is?= " + user);
        System.out.println("Password Is?= " + password);
 
        if (user.equals("admin") && password.equalsIgnoreCase("admin")) {
            /***** Send Request To Next Resource *****/
            chainObj.doFilter(req, resp);
        } else {
            out.print("<p id='errMsg' style='color: red; font-size: larger;'>Username Or Password Is Invalid. Please Try Again ....!</p>");  
            rdObj = req.getRequestDispatcher("index.jsp");  
            rdObj.include(req, resp);  
        }
 
        out.write("</div></body></html>");
        out.close();
    }

		
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

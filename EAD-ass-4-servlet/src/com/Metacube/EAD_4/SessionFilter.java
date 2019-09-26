package com.Metacube.EAD_4;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter(urlPatterns  = {"/EditProfileServlet", "/FriendServlet", "/VehicleFormServlet", "/VehiclePassServlet", "/EmployeeDetails.jsp", "/VehiclePass.jsp"})
public class SessionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SessionFilter() {

    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		//String email_id = req.getRequestURI();
		//this.context.log("Requested Resource::"+uri);
		
		HttpSession session = req.getSession();
		if(session == null){
			//this.context.log("Unauthorized access request");
			res.sendRedirect("Home.jsp");
		}else{
			String email_id = (String) session.getAttribute("EmailId");
			if(email_id == null){
				res.sendRedirect("Home.jsp");
			}
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}

package pers.design.filter;

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

import pers.design.pojo.User;

/**
 * Servlet Filter implementation class UserFilter
 */
//@WebFilter("/UserFilter")
public class UserFilter implements Filter {


    public UserFilter() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		Object o=req.getSession().getAttribute("user");
		if(o==null) {
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
		}else {
			User user=(User) o;
			if(user.isAdmin()) {
				resp.sendRedirect(req.getContextPath()+"/index.jsp");
			}else {
				chain.doFilter(request, response);//·ÅÐÐ
			}
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

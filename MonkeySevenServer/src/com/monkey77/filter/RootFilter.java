/**
 * @date:创建时间：2015-12-30下午2:54:07
 * @author:mao
 * 
 */
package com.monkey77.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author mao
 * @time 创建时间 2015-12-30下午2:54:07
 * 
 */
public class RootFilter implements Filter{

	/**
	 * @author mao
	 * @date 创建时间：2015-12-30下午2:57:18
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-30下午2:57:18
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		if(request.getServletPath().startsWith("/root")){
			if(request.getSession().getAttribute("root")==null){
				response.sendRedirect(request.getContextPath() + "/login.html");
				return;
			}
		}
		chain.doFilter(req, res);
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-30下午2:57:18
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

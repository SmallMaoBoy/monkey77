/**
 * @date:创建时间：2015-12-21下午11:25:17
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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author mao
 * @time 创建时间 2015-12-21下午11:25:17
 * 
 */
public class LoginFilter implements Filter{

	/**
	 * @author mao
	 * @date 创建时间：2015-12-21下午11:26:04
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-21下午11:26:04
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		   HttpServletRequest request = (HttpServletRequest) req;
		   HttpServletResponse response = (HttpServletResponse) res;
		   HttpSession session=request.getSession();
		   Cookie[] cookies = request.getCookies(); 
		   String sessionid = session.getId(); // 取得当前的session id
		   Cookie ckSessionid = new Cookie("sessionid", sessionid);
               for (int i = 0; i < cookies.length; i++) { 
                   Cookie cookie = cookies[i];
                   System.out.println(cookie.getName()+"---"+cookie.getValue());
               }
               Cookie cookie=new Cookie("mobile","");
               response.addCookie(cookie);
               response.addCookie(ckSessionid);
		   arg2.doFilter(req, res);
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-21下午11:26:04
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

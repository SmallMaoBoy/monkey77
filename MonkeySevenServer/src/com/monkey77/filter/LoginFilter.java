/**
 * @date:创建时间：2015-12-21下午11:25:17
 * @author:mao
 * 
 */
package com.monkey77.filter;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Timestamp;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.monkey77.dao.ITCookieValidateDao;
import com.monkey77.dao.TCookieValidateDaoImp;
import com.monkey77.dao.TUserDaoImp;
import com.monkey77.entities.TCookieValidate;
import com.monkey77.entities.TUser;

/**
 * @author mao
 * @time 创建时间 2015-12-21下午11:25:17
 * 
 */
public class LoginFilter implements Filter {

	private String[] excludedPageArray = { "/hou77.html" };

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
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		boolean isExcludedPage = false;

		for (String page : excludedPageArray) {// 判断是否在过滤url之外
			if (((HttpServletRequest) request).getServletPath().equals(page)) {
				isExcludedPage = true;
				break;
			}

		}
		System.out.println("isExcludedPage------>"+isExcludedPage);
		if (!isExcludedPage) {// 在过滤url之外
			chain.doFilter(req, res);
			return;
		}
		Cookie[] cookies = request.getCookies();
		String mobile = "";
		String cookievalidate = "";
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equals("mobile"))
					mobile = cookie.getValue();
				else if (cookie.getName().equals("cookievalidate"))
					cookievalidate = cookie.getValue();
			}
			if (!(mobile.equals("") || mobile.equals("null"))) {
				ApplicationContext ac = new ClassPathXmlApplicationContext(
						"applicationContext.xml");
				ITCookieValidateDao cookieValidateDao = (TCookieValidateDaoImp) ac
						.getBean("CookieValidateDao");
				TUser user = ((TUserDaoImp) ac.getBean("UserDao"))
						.getUserByMobile(mobile);
				TCookieValidate cookieValidate2 = cookieValidateDao
						.getCookieValidate(user);
				Timestamp createtime = cookieValidate2.getCreateTime();
				Timestamp endtime = new Timestamp(System.currentTimeMillis()
						- 1000 * 60 * 60 * 24 * 7);
				if (cookievalidate.equals(cookieValidate2.getSessionId())
						&& endtime.before(createtime)) {
					System.out.println("cookie有效");
					Cookie cookie1 = new Cookie("username", URLEncoder.encode(
							user.getName(), "UTF-8"));
					Cookie cookie2;
					if (user.getSex() == 0) {
						cookie2 = new Cookie("sex", URLEncoder.encode("男",
								"UTF-8"));
					} else {
						cookie2 = new Cookie("sex", URLEncoder.encode("女",
								"UTF-8"));
					}
					Cookie cookie3 = new Cookie("userid", URLEncoder.encode(
							String.valueOf(user.getId()), "UTF-8"));
					response.addCookie(cookie1);
					response.addCookie(cookie2);
					response.addCookie(cookie3);
					chain.doFilter(request, response);
					return;
				} else {
					Cookie cookie1 = new Cookie("mobile", "");
					Cookie cookie2 = new Cookie("cookievalidate", "");
					response.addCookie(cookie1);
					response.addCookie(cookie2);
				}
			} else {
				Cookie cookie1 = new Cookie("mobile", "");
				Cookie cookie2 = new Cookie("cookievalidate", "");
				response.addCookie(cookie1);
				response.addCookie(cookie2);
			}
		} else {
			Cookie cookie1 = new Cookie("mobile", "");
			Cookie cookie2 = new Cookie("cookievalidate", "");
			response.addCookie(cookie1);
			response.addCookie(cookie2);
		}
		chain.doFilter(request, response);
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

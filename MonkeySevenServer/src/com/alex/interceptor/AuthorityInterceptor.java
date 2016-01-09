package com.alex.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorityInterceptor extends AbstractInterceptor {
	//拦截action处理的拦截方法
	public String intercept(ActionInvocation invocation) throws Exception{
		ActionContext ctx=invocation.getInvocationContext();
		Map session =ctx.getSession();
		//取出session里面的user属性
		Object user=session.get("user");
		//如果没有登录，或者登录所用的用户名不对，都返回重新登录
		if(user!=null)
		{
			return invocation.invoke();
		}
		//如果没有登录，将服务器提示放入ActionContext中
		ctx.put("tip", "您还没有登录，请到登录界面登录");
		//直接返回login的逻辑视图
		return Action.LOGIN;
	}

}

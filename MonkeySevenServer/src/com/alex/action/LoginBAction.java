package com.alex.action;



import com.alex.DAO.LoginBDao;
import com.alex.entity.TBuyer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginBAction extends ActionSupport {  
	  
    private long id;  
    private String username;  
    private String password;  
      
    @Override  
    public String execute() throws Exception {  
        LoginBDao loginDao = new LoginBDao();  
        TBuyer user = new TBuyer();  
        user.setAccount(username);
        user.setPassword(password);  
        if(loginDao.check(user)) {  
        	ActionContext.getContext().getSession().put("user",user);
        	System.out.print(user);
            return "Success";
        }  
        return "fail";  
    }  
  
    public long getId() {  
        return id;  
    }  
  
    public void setId(long id) {  
        this.id = id;  
    }  
  
    public String getUsername() {  
        return username;  
    }  
  
    public void setUsername(String username) {  
        this.username = username;  
    }  
  
    public String getPassword() {  
        return password;  
    }  
  
    public void setPassword(String password) {  
        this.password = password;  
    }  
      
}

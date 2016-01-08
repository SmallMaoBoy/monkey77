package com.alex.action;
import com.alex.DAO.LoginDao;
import com.alex.entity.TBusiness;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {  
  
    private long id;  
    private String username;  
    private String password;  
      
    @Override  
    public String execute() throws Exception {  
        LoginDao loginDao = new LoginDao();  
        TBusiness user = new TBusiness();  
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
package zhan.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import zhan.domain.User;
import zhan.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User(); //模型驱动获得User对象
	public User getModel() {
		return user;
	}

	@Resource(name="userService")
	private UserService userService; //注入UserService对象
	
	/*
	 * 用户注册
	 */
	public String regist() {
		userService.regist(user);
		return LOGIN;
	}
	
	/*
	 * 用户登录
	 */
	public String login() {
		User userExist = userService.login(user);
		if (userExist != null) {
			ServletActionContext.getRequest().getSession().setAttribute("user", userExist);
			return "loginSuccess"; //登录成功
		}else {
			return "loginFail"; //登录失败
		}
	}
}

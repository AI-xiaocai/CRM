package zhan.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import zhan.domain.Customer;
import zhan.domain.User;
import zhan.domain.Visit;
import zhan.service.CustomerService;
import zhan.service.UserService;
import zhan.service.VisitService;

public class VisitAction extends ActionSupport implements ModelDriven<Visit> {
	private Visit visit = new Visit();
	public Visit getModel() {
		return visit;
	}
	
	@Resource(name="visitService")
	private VisitService visitService; 
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="customerService")
	private CustomerService customerService;
	
	public String toAddPage() { //跳转到添加客户拜访页面
		List<User> userList = userService.findAll();
		List<Customer> customerList = customerService.findAll();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("userList", userList);
		request.setAttribute("customerList", customerList);
		
		return "toAddPage";
	}
	
	public String add() { //添加客户拜访
		visitService.add(visit);
		return "add";
	}
	
	private List<Visit> visitList;
	public List<Visit> getVisitList() {
		return visitList;
	}

	public String list() { //查询客户拜访列表,将客户拜访记录集合放到值栈中
		visitList = visitService.findAll();
		return "list";
	}
	
	public String toSelectVisitPage() { //跳转到客户拜访记录查询页面
		List<User> userList = userService.findAll();
		List<Customer> customerList = customerService.findAll();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("userList", userList);
		request.setAttribute("customerList", customerList);
		
		return "toSelectVisitPage";
	}
	
	public String moreCondition() { //多条件查询
		visitList = visitService.moreCondition(visit);
		return "moreCondition";
	}
}

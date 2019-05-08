package zhan.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import zhan.domain.Customer;
import zhan.domain.Dict;
import zhan.domain.PageBean;
import zhan.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private Customer customer = new Customer(); //模型驱动获得Customer对象
	public Customer getModel() {
		return customer;
	}
	
	@Resource(name="customerService")
	private CustomerService customerService; //注入CustomerService对象
	
	public String toAddPage() { //跳转到添加客户页面
		List<Dict> dictList = customerService.findAllDict();
		ServletActionContext.getRequest().setAttribute("dictList", dictList);
		return "toAddPage";
	}
	
	public String add() { //添加客户
		customerService.add(customer);
		return "add";
	}
	
	private List<Customer> customerList;
	public List<Customer> getCustomerList() {
		return customerList;
	}
	
	public String list() { //查询客户列表,将客户集合放到值栈中
		customerList = customerService.findAll();
		return "list";
	}
	
	public String delete() { //删除客户
		int cid = customer.getCid();
		Customer c = customerService.findCustomerByCid(cid);
		if (c != null) {
			customerService.delete(c);
		}
		return "delete";
	}
	
	public String toUpdatePage() { //跳转到修改客户页面
		int cid = customer.getCid();
		Customer c = customerService.findCustomerByCid(cid);
		ServletActionContext.getRequest().setAttribute("customer", c);
		List<Dict> dictList = customerService.findAllDict();
		ServletActionContext.getRequest().setAttribute("dictList", dictList);
		
		return "toUpdatePage";
	}
	
	public String update() { //修改客户
		customerService.update(customer);
		return "update";
	}
	
	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public String listPage() { //分页客户列表,采用属性封装获取currentPage
		PageBean pageBean = customerService.listPage(currentPage);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "listPage";
	}
	
	public String listCondition() { //条件查询客户
		if (customer.getCustName() != null && !"".equals(customer.getCustName())) {
			customerList = customerService.listCondition(customer);
		}else {
			customerList = customerService.findAll();
		}
		return "listCondition";
	}
	
	public String toSelectCusPage() { //跳转到客户信息查询页面
		List<Dict> dictList = customerService.findAllDict();
		ServletActionContext.getRequest().setAttribute("dictList", dictList);
		return "toSelectCusPage";
	}
	
	public String moreCondition() { //多条件查询
		customerList = customerService.moreCondition(customer);
		return "moreCondition";
	}
	
	public String countLevel() { //根据客户级别统计
		List list = customerService.countLevel();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "countLevel";
	}
	
	public String countSource() { //根据客户来源统计
		List list = customerService.countSource();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "countSource";
	}
}

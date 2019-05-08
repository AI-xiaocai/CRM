package zhan.action;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import zhan.domain.Customer;
import zhan.domain.LinkMan;
import zhan.service.CustomerService;
import zhan.service.LinkManService;

public class LinkManAction  extends ActionSupport implements ModelDriven<LinkMan>{
	private LinkMan linkMan = new LinkMan(); //模型驱动获得LinkMan对象
	public LinkMan getModel() {
		return linkMan;
	}
	
	@Resource(name="linkManService")
	private LinkManService linkManService;
	@Resource(name="customerService")
	private CustomerService customerService;
	
	public String toAddPage() { //跳转到添加联系人页面
		List<Customer> customerList = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("customerList", customerList);
		return "toAddPage";
	}
	
	/**
	 * 文件上传
	 * 		(1)在action里面成员变量位置定义上传文件变量(名称需要是表单里面文件上传项的name值)、
	 * 		文件名称变量(名称需要是表单里面文件上传项的name值+FileName).
	 * 		(2)生成变量的get和set方法
	 * @author Zhan
	 */
	private File upload; //上传的文件
	private String uploadFileName; //上传文件的名称
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String add() throws Exception { //添加联系人
		if (upload != null) { //上传的文件不为null,则进行上传操作
			String path = ServletActionContext.getServletContext().getRealPath("/uploadFile");
			File serverFile = new File(path + "/" + uploadFileName);
			FileUtils.copyFile(upload, serverFile);
		}
		
		linkManService.add(linkMan);
		return "add";
	}
	
	private List<LinkMan> linkManList;
	public List<LinkMan> getLinkManList() {
		return linkManList;
	}
	
	public String list() { //查询联系人列表,将联系人集合放到值栈中
		linkManList = linkManService.findAll();
		return "list";
	}
	
	public String delete() { //删除联系人
		int lid = linkMan.getLid();
		LinkMan lMan = linkManService.findLinkManByLid(lid);
		if (lMan != null) {
			linkManService.delete(lMan);
		}
		return "delete";
	}
	
	public String toUpdatePage() { //跳转到修改联系人页面
		List<Customer> customerList = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("customerList", customerList);
		
		int lid = linkMan.getLid();
		LinkMan lMan = linkManService.findLinkManByLid(lid);
		ServletActionContext.getRequest().setAttribute("linkMan", lMan);
		
		return "toUpdatePage";
	}
	
	public String update() { //修改联系人
		linkManService.update(linkMan);
		return "update";
	}

	public String listCondition() { //条件查询联系人
		if (linkMan.getLkmName() != null && !"".equals(linkMan.getLkmName())) {
			linkManList = linkManService.listCondition(linkMan);
		}else {
			linkManList = linkManService.findAll();
		}
		return "listCondition";
	}
	
	public String toSelectLinkManPage() { //跳转到联系人信息查询页面
		List<Customer> list = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toSelectLinkManPage";
	}
	
	public String moreCondition() { //多条件查询
		linkManList = linkManService.moreCondition(linkMan);
		return "moreCondition";
	}
}

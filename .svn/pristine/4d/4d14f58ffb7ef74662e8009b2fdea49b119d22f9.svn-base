package zhan.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import zhan.dao.CustomerDao;
import zhan.domain.Customer;
import zhan.domain.Dict;
import zhan.domain.PageBean;

@Transactional
public class CustomerService {
	@Resource(name="customerDao")
	private CustomerDao customerDao; //注入CustomerDao对象

	public void add(Customer customer) { //添加客户
		customerDao.add(customer);
	}

	public List<Customer> findAll() { //查询客户列表
		return customerDao.findAll();
	}

	public Customer findCustomerByCid(int cid) { //通过Cid查询客户
		return customerDao.findOneById(cid);
	}

	public void delete(Customer c) { //删除客户
		customerDao.delete(c);
	}

	public void update(Customer customer) { //修改客户
		customerDao.update(customer);
	}

	public PageBean listPage(Integer currentPage) { //分页客户列表
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage); //设置当前页
		
		int totalCount = customerDao.getTotalCount();
		pageBean.setTotalCount(totalCount); //设置总个数
		
		int pageSize = 3; //定义每页显示3条记录
		
		int totalPage = totalCount / pageSize + (totalCount % pageSize == 0 ? 0 : 1);
		pageBean.setTotalPage(totalPage); //设置总页数
		
		int beginIndex = (currentPage - 1) * pageSize;
		pageBean.setBeginIndex(beginIndex); //设置开始索引
		
		List<Customer> list = customerDao.getList(beginIndex, pageSize);
		pageBean.setList(list); //设置指定页客户列表集合
		
		return pageBean;
	}

	public List<Customer> listCondition(Customer customer) { //条件查询客户
		return customerDao.listCondition(customer);
	}

	public List<Customer> moreCondition(Customer customer) { //多条件查询
		return customerDao.moreCondition(customer);
	}

	public List<Dict> findAllDict() { //查询所有客户等级
		return customerDao.findAllDict();
	}

	public List countLevel() { //根据客户级别统计
		return customerDao.countLevel();
	}

	public List countSource() { //根据客户来源统计
		return customerDao.countSource();
	}

	
}

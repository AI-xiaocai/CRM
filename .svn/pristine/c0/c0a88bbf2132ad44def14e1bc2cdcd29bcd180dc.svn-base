package zhan.dao;

import java.util.List;

import zhan.domain.Customer;
import zhan.domain.Dict;

public interface CustomerDao extends BaseDao<Customer> {

//	public void add(Customer customer);

//	public List<Customer> findAll();

//	public Customer findCustomerByCid(int cid);

//	public void delete(Customer c);

//	public void update(Customer customer);

	public int getTotalCount();

	public List<Customer> getList(int beginIndex, int pageSize);

	public List<Customer> listCondition(Customer customer);

	public List<Customer> moreCondition(Customer customer);

	public List<Dict> findAllDict();

	public List countLevel();

	public List countSource();

}

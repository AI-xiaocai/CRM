package zhan.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import zhan.domain.Customer;
import zhan.domain.Dict;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{

	//添加客户
//	public void add(Customer customer) {
//		super.getHibernateTemplate().save(customer);
//	}

	//查询客户列表
//	public List<Customer> findAll() {
//		return (List<Customer>) super.getHibernateTemplate().find("from Customer");
//	}

	//根据Cid查询客户
//	public Customer findCustomerByCid(int cid) {
//		return super.getHibernateTemplate().get(Customer.class, cid);
//	}

	//删除客户
//	public void delete(Customer c) {
//		super.getHibernateTemplate().delete(c);
//	}

	//修改客户
//	public void update(Customer customer) {
//		super.getHibernateTemplate().update(customer);
//	}

	//查询总记录数
	public int getTotalCount() {
		List<Object> list = (List<Object>) super.getHibernateTemplate().find("select count(*) from Customer");
		if (list != null && list.size() != 0) {
			Long num = (Long) list.get(0);
			return num.intValue();
		}
		return 0;
	}

	//查询指定页客户列表集合(使用离线对象和hibernateTemplate的方法实现)
	public List<Customer> getList(int beginIndex, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		return (List<Customer>) super.getHibernateTemplate().findByCriteria(criteria, beginIndex, pageSize);
	}

	//条件查询客户(使用离线对象和hibernateTemplate的方法实现)
	public List<Customer> listCondition(Customer customer) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		criteria.add(Restrictions.like("custName", "%" + customer.getCustName() + "%"));
		return (List<Customer>) super.getHibernateTemplate().findByCriteria(criteria);
	}

	 //多条件查询
	public List<Customer> moreCondition(Customer customer) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		if (customer.getCustName() != null && !"".equals(customer.getCustName())) {
			criteria.add(Restrictions.like("custName", "%" + customer.getCustName() + "%"));
		}
		if (customer.getDictCustLevel().getDid() != null && customer.getDictCustLevel().getDid() > 0) {
			criteria.add(Restrictions.eq("dictCustLevel.did",customer.getDictCustLevel().getDid()));
		}
		if (customer.getCustSource() != null && !"".equals(customer.getCustSource())) {
			criteria.add(Restrictions.like("custSource", "%" + customer.getCustSource() + "%"));
		}
		
		return (List<Customer>) super.getHibernateTemplate().findByCriteria(criteria);
	}

	//查询所有客户等级
	public List<Dict> findAllDict() {
		return (List<Dict>) super.getHibernateTemplate().find("from Dict");
	}

	//根据客户级别统计(复杂语句可以通过调用底层sql实现)
	public List countLevel() {
		Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery("SELECT COUNT(*) AS num,dname FROM t_customer c,t_dict d WHERE c.custLevel=d.did GROUP BY dname");
		//sqlQuery.list()默认返回的list集合中每部分是数组类型,为方便取数据,先转化为Map类型
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		List list = sqlQuery.list();
		
		return list;
	}

	//根据客户来源统计
	public List countSource() {
		Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery("SELECT COUNT(*) AS num,custSource FROM t_customer GROUP BY custSource");
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		List list = sqlQuery.list();
		
		return list;
	}
}
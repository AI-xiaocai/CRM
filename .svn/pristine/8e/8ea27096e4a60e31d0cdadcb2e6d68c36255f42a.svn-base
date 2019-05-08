package zhan.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import zhan.domain.Visit;

public class VisitDaoImpl extends BaseDaoImpl<Visit> implements VisitDao {

	//多条件查询
	public List<Visit> moreCondition(Visit visit) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Visit.class);
		if (visit.getCustomer().getCid() != null && visit.getCustomer().getCid() > 0) {
			criteria.add(Restrictions.eq("customer.cid", visit.getCustomer().getCid()));
		}
		if (visit.getUser().getUid() != null && visit.getUser().getUid() > 0) {
			criteria.add(Restrictions.eq("user.uid", visit.getUser().getUid()));
		}
		return (List<Visit>) super.getHibernateTemplate().findByCriteria(criteria);
	}

	//添加客户拜访
//	public void add(Visit visit) {
//		super.getHibernateTemplate().save(visit);
//	}

	//查询客户拜访列表
//	public List<Visit> findAll() {
//		return (List<Visit>) super.getHibernateTemplate().find("from Visit");
//	}
	
}

package zhan.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import zhan.domain.Visit;

public class VisitDaoImpl extends BaseDaoImpl<Visit> implements VisitDao {

	//��������ѯ
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

	//��ӿͻ��ݷ�
//	public void add(Visit visit) {
//		super.getHibernateTemplate().save(visit);
//	}

	//��ѯ�ͻ��ݷ��б�
//	public List<Visit> findAll() {
//		return (List<Visit>) super.getHibernateTemplate().find("from Visit");
//	}
	
}

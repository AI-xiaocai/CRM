package zhan.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import zhan.domain.LinkMan;

public class LinkManDaoImpl extends BaseDaoImpl<LinkMan> implements LinkManDao {

	//������ϵ��
//	public void add(LinkMan linkMan) {
//		super.getHibernateTemplate().save(linkMan);
//	}

	//��ѯ��ϵ���б�
//	public List<LinkMan> findAll() {
//		return (List<LinkMan>) super.getHibernateTemplate().find("from LinkMan");
//	}
	
	//����lid��ѯ��ϵ��
//	public LinkMan findLinkManByLid(int lid) {
//		return super.getHibernateTemplate().get(LinkMan.class, lid);
//	}

	//ɾ����ϵ��
//	public void delete(LinkMan lMan) {
//		super.getHibernateTemplate().delete(lMan);
//	}
	
	//�޸���ϵ��
//	public void update(LinkMan linkMan) {
//		super.getHibernateTemplate().update(linkMan);
//	}

	//������ѯ��ϵ��
	public List<LinkMan> listCondition(LinkMan linkMan) {
		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
		criteria.add(Restrictions.like("lkmName", "%" + linkMan.getLkmName() + "%"));
		return (List<LinkMan>) super.getHibernateTemplate().findByCriteria(criteria);
	}

	//��������ѯ
	public List<LinkMan> moreCondition(LinkMan linkMan) {
		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
		if (linkMan.getLkmName() != null && !"".equals(linkMan.getLkmName())) {
			criteria.add(Restrictions.like("lkmName", "%" + linkMan.getLkmName() + "%"));
		}
		if (linkMan.getCustomer().getCid() != null && linkMan.getCustomer().getCid() > 0) {
			criteria.add(Restrictions.eq("customer.cid", linkMan.getCustomer().getCid()));
		}
		
		return (List<LinkMan>) super.getHibernateTemplate().findByCriteria(criteria);
	}

}
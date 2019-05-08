package zhan.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import zhan.dao.VisitDao;
import zhan.domain.Visit;

@Transactional
public class VisitService {
	@Resource(name="visitDao")
	private VisitDao visitDao;

	public void add(Visit visit) { //��ӿͻ��ݷ�
		visitDao.add(visit);
	}

	public List<Visit> findAll() { //��ѯ�ͻ��ݷ��б�
		return visitDao.findAll();
	}

	public List<Visit> moreCondition(Visit visit) { //��������ѯ
		return visitDao.moreCondition(visit);
	}
	
}

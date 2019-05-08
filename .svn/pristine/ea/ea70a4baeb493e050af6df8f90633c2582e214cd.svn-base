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

	public void add(Visit visit) { //添加客户拜访
		visitDao.add(visit);
	}

	public List<Visit> findAll() { //查询客户拜访列表
		return visitDao.findAll();
	}

	public List<Visit> moreCondition(Visit visit) { //多条件查询
		return visitDao.moreCondition(visit);
	}
	
}

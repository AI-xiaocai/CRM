package zhan.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import zhan.dao.LinkManDao;
import zhan.domain.LinkMan;

@Transactional
public class LinkManService {
	@Resource(name="linkManDao")
	private LinkManDao linkManDao;

	public void add(LinkMan linkMan) { //添加联系人
		linkManDao.add(linkMan);
	}

	public List<LinkMan> findAll() { //查询联系人列表
		return linkManDao.findAll();
	}

	public LinkMan findLinkManByLid(int lid) { //通过lid查询联系人
		return linkManDao.findOneById(lid);
	}
	
	public void delete(LinkMan lMan) { //删除联系人
		linkManDao.delete(lMan);
	}
	
	public void update(LinkMan linkMan) { //修改联系人
		linkManDao.update(linkMan);
	}
	
	public List<LinkMan> listCondition(LinkMan linkMan) { //条件查询联系人
		return linkManDao.listCondition(linkMan);
	}

	public List<LinkMan> moreCondition(LinkMan linkMan) { //多条件查询
		return linkManDao.moreCondition(linkMan);
	}
}

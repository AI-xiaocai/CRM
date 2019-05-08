package zhan.dao;

import java.util.List;

import zhan.domain.LinkMan;

public interface LinkManDao extends BaseDao<LinkMan> {

//	public void add(LinkMan linkMan);

//	public List<LinkMan> findAll();

	public List<LinkMan> listCondition(LinkMan linkMan);

	public List<LinkMan> moreCondition(LinkMan linkMan);

//	public LinkMan findLinkManByLid(int lid);

//	public void delete(LinkMan lMan);

//	public void update(LinkMan linkMan);

}

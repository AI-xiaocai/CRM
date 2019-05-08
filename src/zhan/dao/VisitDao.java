package zhan.dao;

import java.util.List;

import zhan.domain.Visit;

public interface VisitDao extends BaseDao<Visit> {

	List<Visit> moreCondition(Visit visit);

//	public void add(Visit visit);

//	public List<Visit> findAll();
	
}

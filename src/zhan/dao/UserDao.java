package zhan.dao;

import java.util.List;

import zhan.domain.User;

public interface UserDao extends BaseDao<User>{

	public void regist(User user);

	public User login(User user);

//	public List<User> findAll();

}

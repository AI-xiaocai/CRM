package zhan.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import zhan.domain.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	/*
	 * 用户注册
	 */
	@Override
	public void regist(User user) {
		super.getHibernateTemplate().save(user);
	}

	/*
	 * 用户登录
	 */
	@SuppressWarnings("all")
	@Override
	public User login(User user) {
		List<User> userList = (List<User>) super.getHibernateTemplate().
				find("from User where username=? and password=?", user.getUsername(),user.getPassword());
		if (userList != null && userList.size() != 0) {
			return userList.get(0);
		}
		return null;
	}

	/*
	 * 查询所有用户
	 */
//	public List<User> findAll() {
//		return (List<User>) super.getHibernateTemplate().find("from User");
//	}	
}
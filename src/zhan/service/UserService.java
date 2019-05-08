package zhan.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import zhan.dao.UserDao;
import zhan.domain.User;

@Transactional
public class UserService {
	@Resource(name="userDao")
	private UserDao userDao; //注入UserDao对象

	/*
	 * 用户注册
	 */
	public void regist(User user) {
		userDao.regist(user);
	}

	/*
	 * 用户登录
	 */
	public User login(User user) {
		return userDao.login(user);
	}

	/*
	 * 查询所有用户
	 */
	public List<User> findAll() {
		return userDao.findAll();
	}
}

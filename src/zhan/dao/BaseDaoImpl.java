package zhan.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class<T> clazz; //在构造方法中获取泛型类的Class对象
	public BaseDaoImpl() {
		clazz = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	//添加
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	//删除
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	//修改
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	//根据id查找
	public T findOneById(int id) {
		return this.getHibernateTemplate().get(clazz, id);
	}

	//查找全部
	public List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().find("from " + clazz.getSimpleName());
	}

}

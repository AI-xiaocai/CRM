package zhan.dao;

import java.util.List;
/*
 * ��ȡBaseDao
 */
public interface BaseDao<T> {
	
	public void add(T t); //���
	
	public void delete(T t); //ɾ��
	
	public void update(T t); //�޸�
	
	public T findOneById(int id); //����id����
	
	public List<T> findAll(); //����ȫ��
}

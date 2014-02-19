package com.shrj.rfid.dao;

import com.shrj.util.ReflectionUtils;

/**
 * 封装Hibernate原生API的DAO泛型基类.
 * <p/>
 * 可在Service层直接使用, 也可以扩展泛型DAO子类使用, 见两个构造函数的注释. 参考Spring2.5自带的Petlinc例子,
 * 取消了HibernateTemplate, 直接使用Hibernate原生API.
 * 
 * @param <T>
 *            DAO操作的对象类型
 * @author cjp
 */
@SuppressWarnings("unchecked")
public abstract class BaseDAO<T> {
	protected Class<T> entityClass;

	/**
	 * 用于Dao层子类使用的构造函数. 通过子类的泛型定义取得对象类型Class. eg. public class UserDao extends
	 * BaseDao<User>
	 */
	public BaseDAO() {
		entityClass = ReflectionUtils.getSuperClassGenricType(getClass());
	}

}
package com.shrj.rfid.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDBDAO<T> extends BaseDAO<T> {
	protected SessionFactory sessionFactory;
	protected JdbcTemplate jdbcTemplate;

	public BaseDBDAO() {
		super();
	}

	/**
	 * 采用@Autowired按类型注入SessionFactory, 当有多个SesionFactory的时候在子类重载本函数.
	 */
	@Autowired
	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 取得当前Session.
	 * 
	 * @return session
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(final T entity) {
		getSession().save(entity);
	}

	public T get(final Serializable id) {
		return (T) getSession().get(entityClass, id);
	}

	public void delete(final Serializable id) {
		Object o = get(id);
		if (o != null) {
			getSession().delete(o);
		}
	}

	public void update(final T entity) {
		getSession().update(entity);
	}

	public void saveOrUpdate(final T entity) {
		getSession().saveOrUpdate(entity);
	}

//	/**
//	 * 返回对应的实体对象的列表
//	 * 
//	 * @param hql
//	 *            sql
//	 * @param cacheMinutes
//	 *            缓存时间
//	 * @return List
//	 */
//	public List<T> doQueryEntityList(String hql, int cacheMinutes) {
//		String key = getSqlKey(hql, null);
//		if (cacheMinutes > 0) {
//			List list = (List) MemcachedClient.get(key);
//			if (list != null && list.size() > 0) {
//				return list;
//			}
//		}
//
//		Query query = getSession().createQuery(hql);
//		List list = query.list();
//		if (cacheMinutes > 0) {
//			MemcachedClient.update(key, list, cacheMinutes);
//		}
//		return list;
//	}

	public List<T> doQueryEntityList(String hql) {
		return getSession().createQuery(hql).list();
	}

	public List<T> doQueryEntityLimitList(String hql, int cacheMinutes, int size) {
		/*
		 * String key = getSqlKey(hql, null); if (cacheMinutes > 0) { List list
		 * = (List) MemcachedClient.get(key); if (list != null && list.size() >
		 * 0) { return list; } }
		 */

		Query query = getSession().createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(size);
		List list = query.list();
		/*
		 * if (cacheMinutes > 0) { MemcachedClient.set(key, list, cacheMinutes);
		 * }
		 */
		return list;
	}

	public void doSql(String sql, final Object... values) {
		SQLQuery sqlQuery = getSession().createSQLQuery(sql);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				sqlQuery.setParameter(i, values[i]);
			}
		}
		sqlQuery.executeUpdate();
	}

	public List doSqlQuery(String sql, final Object... values) {
		SQLQuery sqlQuery = getSession().createSQLQuery(sql);
		return sqlQuery.list();
	}

	public List<Map<String, Object>> doQueryMapList(String sql,
			Object... values) {
		List list = jdbcTemplate.queryForList(sql, values);
		return list;
	}

	// // 生成sql对应的memcached key
	// private String getSqlKey(String sql, Object[] values) {
	// String valueKey = "";
	// if (values != null && values.length > 0) {
	// valueKey = StringUtils.join(values, ",");
	// }
	// valueKey = sql + "_" + valueKey;
	// MD5 md5 = new MD5();
	// return md5.getMD5ofStr(valueKey);
	// }

//	// 生成sql对应的memcached key
//	private String getSqlKey(String sql, int curPage, int pageSize,
//			Object[] values) {
//		String valueKey = "";
//		if (values != null && values.length > 0) {
//			valueKey = StringUtils.join(values, ",");
//		}
//		valueKey = sql + "_" + curPage + "_" + pageSize + valueKey;
//		MD5 md5 = new MD5();
//		return md5.getMD5ofStr(valueKey);
//	}

//	/**
//	 * hql分页 hibernate
//	 */
//	public JdbcPage<T> doQuery(String sql, int total, int curPage,
//			int pageSize, int cacheMinutes, Object... values) {
//		String key = getSqlKey(sql, curPage, pageSize, values);
//		if (cacheMinutes > 0) {
//			JdbcPage jdbcPage = (JdbcPage) MemcachedClient.get(key);
//			if (jdbcPage != null) {
//				return jdbcPage;
//			}
//		}
//		JdbcPage jdbcPage = new JdbcPage<T>(sql, entityClass, total,
//				sessionFactory, curPage, pageSize, values);
//		if (cacheMinutes > 0) {
//			MemcachedClient.update(key, jdbcPage, cacheMinutes);
//		}
//		return jdbcPage;
//	}

//	/**
//	 * 计算未读 新增数
//	 */
//	public long doQueryCount(String hql, int cacheMinutes, Object... values) {
//		long msgCount = 0;
//		if (cacheMinutes > 0) {
//			String key = getSqlKey(hql, null);
//			Object object = MemcachedClient.get(key);
//			msgCount = (Long) object;
//			return msgCount;
//		}
//		Query totalQuery = getSession().createQuery(hql);
//		if (values != null && values.length > 0) {
//			for (int i = 0; i < values.length; i++) {
//				totalQuery.setParameter(i, values[i]);
//			}
//		}
//		msgCount = ((Long) (totalQuery).uniqueResult()).longValue();
//		if (cacheMinutes > 0) {
//			MemcachedClient.update(getSqlKey(hql, null), msgCount, cacheMinutes);
//		}
//		return msgCount;
//	}

	/**
	 * 获得第一行对象
	 */
	public T doQueryEntityFirst(String sql, int cacheMinutes,
			final Object... values) {
		sql = sql + " ";
		List<T> list = this.doQueryEntityLimitList(sql, cacheMinutes, 1);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

}

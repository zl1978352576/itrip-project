package cn.itrip.dao.common;
import cn.itrip.common.Constants;
import cn.itrip.common.Page;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericDAOImpl  extends SqlSessionDaoSupport implements GenericDAO{

	private static HashMap<String, SqlSessionFactory> sessionFactoryMap;

	private static Map<String, GenericDAOImpl> instances = new HashMap();

	protected static final String DEFAULT = "default";

	private static Log logger = LogFactory.getLog(GenericDAOImpl.class);

	public static GenericDAOImpl getInstance(String dbStr) {

		if(dbStr == null || "".equals(dbStr) || "null".equals(dbStr))
			dbStr = DEFAULT;

		if (!instances.containsKey(dbStr)) {
			SqlSessionFactory sqlSessionFactory = sessionFactoryMap.get(dbStr);
			if (sqlSessionFactory == null) {
				throw new RuntimeException("dbStr=" + dbStr + ",未找到对应的sqlSessionFactory");
			}
			GenericDAOImpl dao = new GenericDAOImpl();
			dao.setSqlSessionFactory(sqlSessionFactory);
			instances.put(dbStr, dao);

			return dao;
		}
		logger.debug("GenericDAOImpl  instances.get("+dbStr+")");
		return  instances.get(dbStr);
	}


	public int count(String statement, Object parameter) {
		return count(statement, parameter, DEFAULT);
	}

	public int count(String statement, Object parameter, String dbStr) {
		Integer count = (Integer) getInstance(dbStr).getSqlSession().selectOne(statement, parameter);
		if(count != null){
			return count.intValue();
		}
		return 0;
	}

	@Override
	public List list(String statement, Object parameter) {
		return list(statement, parameter, DEFAULT);
	}

	@Override
	public List list(String statement, Object parameter, String dbStr) {
		return getInstance(dbStr).getSqlSession().selectList(statement, parameter);
	}


	public List list(String statement, Object parameter, RowBounds rowBounds) {
		return list(statement, parameter, rowBounds, DEFAULT);
	}

	public List list(String statement, Object parameter, RowBounds rowBounds, String dbStr) {
		return getInstance(dbStr).getSqlSession().selectList(statement, parameter, rowBounds);
	}

	@Override
	public Object object(String statement, Object parameter) {
		return object(statement, parameter, DEFAULT);
	}

	@Override
	public Object object(String statement, Object parameter, String dbStr) {
		return getInstance(dbStr).getSqlSession().selectOne(statement, parameter);
	}

	@Override
	public Map map(String statement, Object parameter, String mapKey) {
		return map(statement, parameter, mapKey, DEFAULT);
	}

	public Map map(String statement, Object parameter, String mapKey, String dbStr) {
		return getInstance(dbStr).getSqlSession().selectMap(statement, parameter, mapKey);
	}


	@Override
	public Map map(String statement, Object parameter, String mapKey,
				   RowBounds rowBounds) {
		return map(statement, parameter, mapKey, rowBounds, DEFAULT);
	}

	@Override
	public Map map(String statement, Object parameter, String mapKey,
				   RowBounds rowBounds, String dbStr) {
		return getInstance(dbStr).getSqlSession().selectMap(statement, parameter, mapKey, rowBounds);
	}


	@Override
	public Page getPage(String countStatement, String dataStatement, Object parameter, int curPage) {
		Page page = new Page(curPage);

		return getPage(countStatement, dataStatement, parameter, page, DEFAULT);
	}

	public Page getPage(String countStatement, String dataStatement, Object parameter, int curPage, String dbStr) {
		Page page = new Page(curPage);
		return getPage(countStatement, dataStatement, parameter, page, dbStr);
	}

	@Override
	public Page getPage(String countStatement, String dataStatement,
						Object parameter, int curPage, int pageSize) {
		Page page = new Page(curPage, pageSize);
		return getPage(countStatement, dataStatement, parameter, page, DEFAULT);
	}

	public Page getPage(String countStatement, String dataStatement,
						Object parameter, int curPage, int pageSize, String dbStr) {
		Page page = new Page(curPage, pageSize);
		return getPage(countStatement, dataStatement, parameter, page, dbStr);
	}

	@Override
	public Page getPage(String countStatement, String dataStatement,
						Object parameter, Page page) {

		return getPage(countStatement, dataStatement, parameter, page, DEFAULT);
	}

	public Page getPage(String countStatement, String dataStatement,
						Object parameter, Page page, String dbStr) {

		if (page == null) {
			page = new Page(1);
		}

		int rowCount =  count(countStatement, parameter, dbStr);
		page.setRowCount(rowCount);

		if (rowCount > 0L) {
			int offset = Long.valueOf(page.getBeginPos()).intValue() - 1;
			int limit = Long.valueOf(page.getPageSize()).intValue();
			RowBounds rowBounds = new RowBounds(offset, limit);

			List l = list(dataStatement ,parameter, rowBounds, dbStr);
			page.setRows(l);
		} else {
			page.setRows(new ArrayList());
		}

		return page;
	}


	@Override
	public Page getPage(Class clazz, Object parameter, int curPage) {
		String countStatement = clazz.getName() + "." + Constants.PAGE_SELECT_COUNT_EXAMPLE_STATEMENT;
		String dataStatement = clazz.getName() + "."  + Constants.PAGE_SELECT_EXAMPLE_STATEMENT;
		return getPage(countStatement, dataStatement, parameter, curPage);
	}

	public Page getPage(Class clazz, Object parameter, int curPage, String dbStr) {
		String countStatement = clazz.getName() + "." + Constants.PAGE_SELECT_COUNT_EXAMPLE_STATEMENT;
		String dataStatement = clazz.getName() + "."  + Constants.PAGE_SELECT_EXAMPLE_STATEMENT;
		return getPage(countStatement, dataStatement, parameter, curPage, dbStr);
	}

	@Override
	public Page getPage(Class clazz, Object parameter, int curPage,
						int pageSize) {
		String countStatement = clazz.getName() + "." + Constants.PAGE_SELECT_COUNT_EXAMPLE_STATEMENT;
		String dataStatement = clazz.getName() + "."  + Constants.PAGE_SELECT_EXAMPLE_STATEMENT;
		return getPage(countStatement, dataStatement, parameter, curPage, pageSize);
	}

	public Page getPage(Class clazz, Object parameter, int curPage,
						int pageSize, String dbStr) {
		String countStatement = clazz.getName() + "." + Constants.PAGE_SELECT_COUNT_EXAMPLE_STATEMENT;
		String dataStatement = clazz.getName() + "."  + Constants.PAGE_SELECT_EXAMPLE_STATEMENT;
		return getPage(countStatement, dataStatement, parameter, curPage, pageSize, dbStr);
	}

	@Override
	public Page getPage(Class clazz, Object parameter, Page page) {
		String countStatement = clazz.getName() + "." + Constants.PAGE_SELECT_COUNT_EXAMPLE_STATEMENT;
		String dataStatement = clazz.getName() + "."  + Constants.PAGE_SELECT_EXAMPLE_STATEMENT;
		return getPage(countStatement, dataStatement, parameter, page);
	}

	public Page getPage(Class clazz, Object parameter, Page page, String dbStr) {
		String countStatement = clazz.getName() + "." + Constants.PAGE_SELECT_COUNT_EXAMPLE_STATEMENT;
		String dataStatement = clazz.getName() + "."  + Constants.PAGE_SELECT_EXAMPLE_STATEMENT;
		return getPage(countStatement, dataStatement, parameter, page, dbStr);
	}


	public int update(String statement, Object parameter){
		return update(statement, parameter, DEFAULT);
	}

	public int update(String statement, Object parameter, String dbStr){
		return getInstance(dbStr).getSqlSession().update(statement, parameter);
	}


	public int insert(String statement, Object parameter) {
		return insert(statement, parameter, DEFAULT);
	}

	public int insert(String statement, Object parameter, String dbStr) {
		return getInstance(dbStr).getSqlSession().insert(statement, parameter);
	}

	public int delete(String statement, Object parameter) {
		return delete(statement, parameter, DEFAULT);
	}

	public int delete(String statement, Object parameter, String dbStr) {
		return getInstance(dbStr).getSqlSession().delete(statement, parameter);
	}


	public Map<String, SqlSessionFactory> getSessionFactoryMap() {
		return sessionFactoryMap;
	}

	public void setSessionFactoryMap(Map<String, SqlSessionFactory> sessionFactoryMap) {
		sessionFactoryMap = sessionFactoryMap;
	}
}

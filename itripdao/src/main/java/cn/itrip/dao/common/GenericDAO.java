package cn.itrip.dao.common;

import cn.itrip.common.Page;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface GenericDAO {
	
	 int count(String statement, Object parameter);
	 int count(String statement, Object parameter, String dbStr);
	
	 //List list(String statement);
	 List list(String statement, Object parameter);
	 List list(String statement, Object parameter, String dbStr);
	 
	 List list(String statement, Object parameter, RowBounds rowBounds);
	 List list(String statement, Object parameter, RowBounds rowBounds, String dbStr);
	
	 //Object object(String statement);
	 Object object(String statement, Object parameter);
	 Object object(String statement, Object parameter, String dbStr);
	
	 Map map(String statement, Object parameter, String mapKey);
	 Map map(String statement, Object parameter, String mapKey, String dbStr);
	 
	 Map map(String statement, Object parameter, String mapKey, RowBounds rowBounds);
	 Map map(String statement, Object parameter, String mapKey, RowBounds rowBounds, String dbStr);
	
	 Page getPage(String countStatement, String dataStatement, Object parameter, int curPage);
	 Page getPage(String countStatement, String dataStatement, Object parameter, int curPage, String dbStr);
	 
	 Page getPage(String countStatement, String dataStatement, Object parameter, int curPage, int pageSize);
	 Page getPage(String countStatement, String dataStatement, Object parameter, int curPage, int pageSize, String dbStr);
	 
	 Page getPage(String countStatement, String dataStatement, Object parameter, Page page);
	 Page getPage(String countStatement, String dataStatement, Object parameter, Page page, String dbStr);
	
	 Page getPage(Class clazz, Object parameter, int curPage);
	 Page getPage(Class clazz, Object parameter, int curPage, String dbStr);
	 
	 Page getPage(Class clazz, Object parameter, int curPage, int pageSize);
	 Page getPage(Class clazz, Object parameter, int curPage, int pageSize, String dbStr);
	 
	 Page getPage(Class clazz, Object parameter, Page page);
	 Page getPage(Class clazz, Object parameter, Page page, String dbStr);
	
	
	
	 //int update(String statement);
	
	 int update(String statement, Object parameter);
	 int update(String statement, Object parameter, String dbStr);
	
	// int insert(String statement);
	
	 int insert(String statement, Object parameter);
	 int insert(String statement, Object parameter, String dbStr);
	
	 int delete(String statement, Object parameter);
	 int delete(String statement, Object parameter, String dbStr);
	
	 //int delete(String statement);
}

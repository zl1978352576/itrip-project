package cn.itrip.dao;
import cn.itrip.common.Constants;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by zezhong.shang on 17-5-5.
 */
public class BaseQuery<T> {

    private HttpSolrClient httpSolrClient;

    static Logger logger=Logger.getLogger(BaseQuery.class);

    public BaseQuery(String url){
        httpSolrClient = new HttpSolrClient(url);
        httpSolrClient.setParser(new XMLResponseParser()); // 设置响应解析器
        httpSolrClient.setConnectionTimeout(500); // 建立连接的最长时间
    }

    public List<T> queryList(String url,Map<String, Object> params, Class clazz) {
        SolrQuery solrQuery = new SolrQuery(); // 构造搜索条件
        QueryResponse queryResponse = null;
        List<T> list = null;
        int flag = 0;
        try {
            if (EmptyUtils.isNotEmpty(params)) {
                Iterator<Map.Entry<String, Object>> it = params.entrySet().iterator();
                StringBuffer queryString = new StringBuffer("");
                while (it.hasNext()) {
                    Map.Entry<String, Object> entry = it.next();
                    if (flag == 0) {
                        queryString = queryString.append(entry.getKey() + ":" + entry.getValue());
                    } else {
                        queryString = queryString.append(" AND " + entry.getKey() + ":" + entry.getValue());
                    }
                    flag++;
                }
                logger.info("queryString:" + queryString);
                if(EmptyUtils.isEmpty(queryString.toString())){
                    queryString.append("*:*");
                }
                solrQuery.setQuery(queryString.toString());
            }
            queryResponse = httpSolrClient.query(solrQuery);
            list = queryResponse.getBeans(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }

    public Page<T> queryPage(Map<String, Object> params,Integer pageNo,Integer pageSize,Class clazz){
        SolrQuery solrQuery = new SolrQuery(); // 构造搜索条件
        QueryResponse queryResponse = null;
        Page<T> page=null;
        List<T> list = null;
        int flag = 0;
        try {
            if (EmptyUtils.isNotEmpty(params)) {
                Iterator<Map.Entry<String, Object>> it = params.entrySet().iterator();
                StringBuffer queryString = new StringBuffer("");
                while (it.hasNext()) {
                    Map.Entry<String, Object> entry = it.next();
                    if (flag == 0) {
                        if(EmptyUtils.isNotEmpty(entry.getValue())){
                            queryString = queryString.append(entry.getKey() + ":" + entry.getValue());
                        }
                    } else {
                        if(EmptyUtils.isNotEmpty(entry.getValue())){
                            queryString = queryString.append(" AND " + entry.getKey() + ":" + entry.getValue());
                        }
                    }
                    flag++;
                }
                solrQuery.setHighlight(true);
                logger.info("queryString:" + queryString);
                if(EmptyUtils.isEmpty(queryString.toString())){
                    queryString.append("*:*");
                }
                solrQuery.setQuery(queryString.toString());
                //设置起始页数
                solrQuery.setStart(EmptyUtils.isEmpty(pageNo)? Constants.DEFAULT_PAGE_NO-1:pageNo-1);
                //一页显示多少条
                solrQuery.setRows(EmptyUtils.isEmpty(pageSize)?Constants.DEFAULT_PAGE_SIZE:pageSize);
            }
            queryResponse = httpSolrClient.query(solrQuery);
            SolrDocumentList docs = queryResponse.getResults();
            page=new Page(solrQuery.getStart(),solrQuery.getRows(),new Long(docs.getNumFound()).intValue());
            list = queryResponse.getBeans(clazz);
            page.setRows(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return page;
        }
    }
}

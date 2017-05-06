package cn.itrip.dao;

import cn.itrip.common.EmptyUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by zezhong.shang on 17-5-5.
 */
public class BaseQuery<T> {

    private static String url;
    private static HttpSolrClient httpSolrClient;

    static {
        // 在url中指定core名称：notice
        String url = "http://localhost:8080/solr/test/";
        httpSolrClient = new HttpSolrClient(url);
        httpSolrClient.setParser(new XMLResponseParser()); // 设置响应解析器
        httpSolrClient.setConnectionTimeout(500); // 建立连接的最长时间
    }

    public List<T> queryList(Map<String, String> params, Class clazz) {
        SolrQuery solrQuery = new SolrQuery(); // 构造搜索条件
        QueryResponse queryResponse = null;
        List<T> list =null;
        int flag = 0;
        try {
            if (EmptyUtils.isNotEmpty(params)) {
                Iterator<Map.Entry<String, String>> it = params.entrySet().iterator();
                while (it.hasNext()) {
                    StringBuffer queryString=new StringBuffer("");
                    Map.Entry<String, String> entry = it.next();
                    if (flag == 0) {
                        queryString=queryString.append(entry.getKey() + ":" + entry.getValue());
                    } else {
                        queryString=queryString.append(" AND " + entry.getKey() + ":" + entry.getValue());
                    }
                    solrQuery.setQuery(queryString.toString());
                    flag++;
                }
            }
            queryResponse = httpSolrClient.query(solrQuery);
            list=queryResponse.getBeans(clazz);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return list;
        }
    }
}

package cn.itrip.solr;

import org.apache.solr.client.solrj.impl.HttpSolrClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zezhong.shang on 17-5-5.
 */
public class SolrjTest {

    private HttpSolrClient httpSolrClient;

    public static void main(String[] args) {
        BaseQuery<ItripAreaDic> itripAreaDicBaseQuery=new BaseQuery<ItripAreaDic>();
        Map<String,String> param=new HashMap<String,String>();
        param.put("keyword","北京");
        param.put("name","北京市22");
        List<ItripAreaDic> itripAreaDicList=itripAreaDicBaseQuery.queryList(param, ItripAreaDic.class);
        for (ItripAreaDic demo:itripAreaDicList){
            System.out.println(demo.getName());
        }
    }
}
package cn.itrip.solr;
import cn.itrip.beans.vo.hotel.ItripHotelVO;
import cn.itrip.dao.BaseQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import java.io.IOException;
import java.util.List;

/**
 * Created by zezhong.shang on 17-5-5.
 */
public class SolrjTest {

    private HttpSolrClient httpSolrClient;

    public static void main(String[] args) throws IOException, SolrServerException {
        BaseQuery<ItripHotelVO> itripAreaDicBaseQuery=new BaseQuery<ItripHotelVO>("http://localhost:8080/solr/hotel/");
//        List<ItripHotelVO> page=itripAreaDicBaseQuery.queryList(null, 1, 10, ItripHotelVO.class);
//        System.out.println(page);
    }
}
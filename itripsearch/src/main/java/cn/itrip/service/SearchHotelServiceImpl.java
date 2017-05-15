package cn.itrip.service;
import cn.itrip.beans.vo.hotel.ItripHotelVO;
import cn.itrip.beans.vo.hotel.SearchHotelVO;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import cn.itrip.common.PropertiesUtils;
import cn.itrip.dao.BaseQuery;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by zezhong.shang on 17-5-7.
 */
@Service
public class SearchHotelServiceImpl implements SearchHotelService {

    public static String URL = PropertiesUtils.get("solr.properties","baseUrl");

    private BaseQuery<ItripHotelVO> itripHotelVOBaseQuery = new BaseQuery(URL);

    @Override
    public Page<ItripHotelVO> searchItripHotelPage(SearchHotelVO vo, Integer pageNo, Integer pageSize) throws Exception {
        SolrQuery query = new SolrQuery("*:*");
        StringBuffer tempQuery=new StringBuffer();
        int tempFlag=0;
        if (EmptyUtils.isNotEmpty(vo)) {
            if (EmptyUtils.isNotEmpty(vo.getDestination())) {
                tempQuery.append(" destination :"+vo.getDestination());
                tempFlag=1;
            }
            if (EmptyUtils.isNotEmpty(vo.getHotelLevel())) {
                query.addFilterQuery("hotelLevel:"+vo.getHotelLevel()+"");
            }
            if (EmptyUtils.isNotEmpty(vo.getKeywords())) {
                if(tempFlag==1){
                    tempQuery.append(" AND keyword :"+vo.getKeywords());
                }else{
                    tempQuery.append(" keyword :"+vo.getKeywords());
                }
            }
            if (EmptyUtils.isNotEmpty(vo.getFeatureIds())) {
                query.addFilterQuery("featureIds:"+"*," + vo.getFeatureIds() + ",*");
            }
            if (EmptyUtils.isNotEmpty(vo.getTradeAreaIds())) {
                query.addFilterQuery("tradingAreaIds:"+"*," + vo.getTradeAreaIds() + ",*");
            }
            if (EmptyUtils.isNotEmpty(vo.getMaxPrice())) {
                query.addFilterQuery("maxPrice:"+"[* TO " + vo.getMaxPrice() + "]");
            }
            if (EmptyUtils.isNotEmpty(vo.getMinPrice())) {
                query.addFilterQuery("minPrice:"+"[" + vo.getMinPrice() + " TO *]");
            }

            if (EmptyUtils.isNotEmpty(vo.getAscSort())) {
                query.addSort(vo.getAscSort(),SolrQuery.ORDER.asc);
            }

            if (EmptyUtils.isNotEmpty(vo.getDescSort())) {
                query.addSort(vo.getDescSort(), SolrQuery.ORDER.desc);
            }
        }
        if(EmptyUtils.isNotEmpty(tempQuery.toString())){
            query.setQuery(tempQuery.toString());
        }
        Page<ItripHotelVO> page= itripHotelVOBaseQuery.queryPage(query, pageNo, pageSize, ItripHotelVO.class);
        return page;
    }

    @Override
    public List<ItripHotelVO> searchItripHotelListByHotCity(Integer cityId, Integer count) throws Exception {
        SolrQuery query = new SolrQuery("*:*");
        if (EmptyUtils.isNotEmpty(cityId)) {
            query.addFilterQuery("cityId:"+cityId);
        } else {
            return null;
        }
        List<ItripHotelVO> hotelVOList = itripHotelVOBaseQuery.queryList(query, count, ItripHotelVO.class);
        return hotelVOList;
    }

}

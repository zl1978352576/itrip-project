package cn.itrip.service;
import cn.itrip.beans.pojo.ItripHotelKeyword;
import java.util.List;
import java.util.Map;
import cn.itrip.beans.pojo.ItripHotelKeywordExample;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface IItripHotelKeywordService {

    public int saveOrUpdateItripHotelKeyword(ItripHotelKeyword obj)throws Exception;

    public ItripHotelKeyword queryItripHotelKeywordById(Long id)throws Exception;

    public int removeItripHotelKeywordByIds(String ids)throws Exception;

    public List<ItripHotelKeyword> queryItripHotelKeywordList(ItripHotelKeywordExample example)throws Exception;

    public Page<ItripHotelKeyword> queryItripHotelKeywordPage(Map params)throws Exception;
}

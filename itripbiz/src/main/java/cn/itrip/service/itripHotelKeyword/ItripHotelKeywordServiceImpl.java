package cn.itrip.service.itripHotelKeyword;
import cn.itrip.dao.itripHotelKeyword.ItripHotelKeywordMapper;
import cn.itrip.beans.pojo.ItripHotelKeyword;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ItripHotelKeywordServiceImpl implements ItripHotelKeywordService {

    @Resource
    private ItripHotelKeywordMapper itripHotelKeywordMapper;

    public ItripHotelKeyword getItripHotelKeywordById(Long id)throws Exception{
        return itripHotelKeywordMapper.getItripHotelKeywordById(id);
    }

    public List<ItripHotelKeyword>	getItripHotelKeywordListByMap(Map<String,Object> param)throws Exception{
        return itripHotelKeywordMapper.getItripHotelKeywordListByMap(param);
    }

    public Integer getItripHotelKeywordCountByMap(Map<String,Object> param)throws Exception{
        return itripHotelKeywordMapper.getItripHotelKeywordCountByMap(param);
    }

    public Integer itriptxAddItripHotelKeyword(ItripHotelKeyword itripHotelKeyword)throws Exception{
            itripHotelKeyword.setCreationDate(new Date());
            return itripHotelKeywordMapper.updateItripHotelKeyword(itripHotelKeyword);
    }

    public Integer itriptxModifyItripHotelKeyword(ItripHotelKeyword itripHotelKeyword)throws Exception{
        itripHotelKeyword.setModifyDate(new Date());
        return itripHotelKeywordMapper.updateItripHotelKeyword(itripHotelKeyword);
    }

    public Integer itriptxDeleteItripHotelKeywordById(Long id)throws Exception{
        return itripHotelKeywordMapper.deleteItripHotelKeywordById(id);
    }

}

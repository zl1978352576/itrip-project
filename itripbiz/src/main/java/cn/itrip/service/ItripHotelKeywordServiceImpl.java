package cn.itrip.service;
import cn.itrip.dao.ItripHotelKeywordMapper;
import cn.itrip.beans.pojo.ItripHotelKeyword;
import cn.itrip.beans.pojo.ItripHotelKeywordExample;
import cn.itrip.service.common.SelectService;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ItripHotelKeywordServiceImpl implements IItripHotelKeywordService {

    @Autowired
    private ItripHotelKeywordMapper itripHotelKeywordMapper;

    @Autowired
    private SelectService<ItripHotelKeyword> selectService;

    public int saveOrUpdateItripHotelKeyword(ItripHotelKeyword itripHotelKeyword) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(itripHotelKeyword.getId())){
            flag=itripHotelKeywordMapper.updateByPrimaryKeySelective(itripHotelKeyword);
        }else{
            flag=itripHotelKeywordMapper.insert(itripHotelKeyword);
        }
        return flag;
    }

    public ItripHotelKeyword queryItripHotelKeywordById(Long id) throws Exception{
        return itripHotelKeywordMapper.selectByPrimaryKey(id);
    }

    public int removeItripHotelKeywordByIds(String ids)throws Exception{
        ItripHotelKeywordExample itripHotelKeywordExample=new ItripHotelKeywordExample();
        List<Long> idsList=new ArrayList<Long>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(Long.parseLong(idsArray[i]));
        }
        itripHotelKeywordExample.createCriteria().andIdIn(idsList);
        int flag=itripHotelKeywordMapper.deleteByExample(itripHotelKeywordExample);
        return flag;
    }

    public List<ItripHotelKeyword> queryItripHotelKeywordList(ItripHotelKeywordExample example)throws Exception{
        return itripHotelKeywordMapper.selectByExample(example);
    }

    public Page<ItripHotelKeyword> queryItripHotelKeywordPage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "ItripHotelKeyword.getItripHotelKeywordCount";
        String listSqlId = "ItripHotelKeyword.getItripHotelKeywordPage";
        Page<ItripHotelKeyword> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }
}

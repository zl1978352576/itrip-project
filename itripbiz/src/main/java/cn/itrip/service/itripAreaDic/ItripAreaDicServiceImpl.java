package cn.itrip.service.itripAreaDic;
import cn.itrip.dao.itripAreaDic.ItripAreaDicMapper;
import cn.itrip.beans.pojo.ItripAreaDic;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ItripAreaDicServiceImpl implements ItripAreaDicService {

    @Resource
    private ItripAreaDicMapper itripAreaDicMapper;

    public ItripAreaDic getItripAreaDicById(Long id)throws Exception{
        return itripAreaDicMapper.getItripAreaDicById(id);
    }

    public List<ItripAreaDic>	getItripAreaDicListByMap(Map<String,Object> param)throws Exception{
        return itripAreaDicMapper.getItripAreaDicListByMap(param);
    }

    public Integer getItripAreaDicCountByMap(Map<String,Object> param)throws Exception{
        return itripAreaDicMapper.getItripAreaDicCountByMap(param);
    }

    public Integer insertItripAreaDic(ItripAreaDic itripAreaDic)throws Exception{
            itripAreaDic.setCreationDate(new Date());
            return itripAreaDicMapper.updateItripAreaDic(itripAreaDic);
    }

    public Integer updateItripAreaDic(ItripAreaDic itripAreaDic)throws Exception{
        itripAreaDic.setModifyDate(new Date());
        return itripAreaDicMapper.updateItripAreaDic(itripAreaDic);
    }

    public Integer deleteItripAreaDicById(Long id)throws Exception{
        return itripAreaDicMapper.deleteItripAreaDicById(id);
    }

}

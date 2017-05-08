package cn.itrip.service.itripLabelDic;
import cn.itrip.dao.itripLabelDic.ItripLabelDicMapper;
import cn.itrip.beans.pojo.ItripLabelDic;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ItripLabelDicServiceImpl implements ItripLabelDicService {

    @Resource
    private ItripLabelDicMapper itripLabelDicMapper;

    public ItripLabelDic getItripLabelDicById(Long id)throws Exception{
        return itripLabelDicMapper.getItripLabelDicById(id);
    }

    public List<ItripLabelDic>	getItripLabelDicListByMap(Map<String,Object> param)throws Exception{
        return itripLabelDicMapper.getItripLabelDicListByMap(param);
    }

    public Integer getItripLabelDicCountByMap(Map<String,Object> param)throws Exception{
        return itripLabelDicMapper.getItripLabelDicCountByMap(param);
    }

    public Integer itriptxAddItripLabelDic(ItripLabelDic itripLabelDic)throws Exception{
            itripLabelDic.setCreationDate(new Date());
            return itripLabelDicMapper.insertItripLabelDic(itripLabelDic);
    }

    public Integer itriptxModifyItripLabelDic(ItripLabelDic itripLabelDic)throws Exception{
        itripLabelDic.setModifyDate(new Date());
        return itripLabelDicMapper.updateItripLabelDic(itripLabelDic);
    }

    public Integer itriptxDeleteItripLabelDicById(Long id)throws Exception{
        return itripLabelDicMapper.deleteItripLabelDicById(id);
    }

}

package cn.itrip.service;
import cn.itrip.dao.ItripLabelDicMapper;
import cn.itrip.beans.pojo.ItripLabelDic;
import cn.itrip.beans.pojo.ItripLabelDicExample;
import cn.itrip.service.common.SelectService;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ItripLabelDicServiceImpl implements IItripLabelDicService {

    @Autowired
    private ItripLabelDicMapper itripLabelDicMapper;

    @Autowired
    private SelectService<ItripLabelDic> selectService;

    public int saveOrUpdateItripLabelDic(ItripLabelDic itripLabelDic) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(itripLabelDic.getId())){
            itripLabelDic.setModifyDate(new Date());
            flag=itripLabelDicMapper.updateByPrimaryKeySelective(itripLabelDic);
        }else{
            itripLabelDic.setCreationDate(new Date());
            flag=itripLabelDicMapper.insert(itripLabelDic);
        }
        return flag;
    }

    public ItripLabelDic queryItripLabelDicById(Long id) throws Exception{
        return itripLabelDicMapper.selectByPrimaryKey(id);
    }

    public int removeItripLabelDicByIds(String ids)throws Exception{
        ItripLabelDicExample itripLabelDicExample=new ItripLabelDicExample();
        List<Long> idsList=new ArrayList<Long>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(Long.parseLong(idsArray[i]));
        }
        itripLabelDicExample.createCriteria().andIdIn(idsList);
        int flag=itripLabelDicMapper.deleteByExample(itripLabelDicExample);
        return flag;
    }

    public List<ItripLabelDic> queryItripLabelDicList(ItripLabelDicExample example)throws Exception{
        return itripLabelDicMapper.selectByExample(example);
    }

    public Page<ItripLabelDic> queryItripLabelDicPage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "ItripLabelDic.getItripLabelDicCount";
        String listSqlId = "ItripLabelDic.getItripLabelDicPage";
        Page<ItripLabelDic> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }
}

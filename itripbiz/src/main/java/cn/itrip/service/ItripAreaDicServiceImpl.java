package cn.itrip.service;
import cn.itrip.dao.ItripAreaDicMapper;
import cn.itrip.beans.pojo.ItripAreaDic;
import cn.itrip.beans.pojo.ItripAreaDicExample;
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
public class ItripAreaDicServiceImpl implements IItripAreaDicService {

    @Autowired
    private ItripAreaDicMapper itripAreaDicMapper;

    @Autowired
    private SelectService<ItripAreaDic> selectService;

    public int saveOrUpdateItripAreaDic(ItripAreaDic itripAreaDic) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(itripAreaDic.getId())){
            itripAreaDic.setModifyDate(new Date());
            flag=itripAreaDicMapper.updateByPrimaryKeySelective(itripAreaDic);
        }else{
            itripAreaDic.setCreationDate(new Date());
            flag=itripAreaDicMapper.insert(itripAreaDic);
        }
        return flag;
    }

    public ItripAreaDic queryItripAreaDicById(Long id) throws Exception{
        return itripAreaDicMapper.selectByPrimaryKey(id);
    }

    public int removeItripAreaDicByIds(String ids)throws Exception{
        ItripAreaDicExample itripAreaDicExample=new ItripAreaDicExample();
        List<Long> idsList=new ArrayList<Long>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(Long.parseLong(idsArray[i]));
        }
        itripAreaDicExample.createCriteria().andIdIn(idsList);
        int flag=itripAreaDicMapper.deleteByExample(itripAreaDicExample);
        return flag;
    }

    public List<ItripAreaDic> queryItripAreaDicList(ItripAreaDicExample example)throws Exception{
        return itripAreaDicMapper.selectByExample(example);
    }

    public Page<ItripAreaDic> queryItripAreaDicPage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "ItripAreaDic.getItripAreaDicCount";
        String listSqlId = "ItripAreaDic.getItripAreaDicPage";
        Page<ItripAreaDic> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }
}

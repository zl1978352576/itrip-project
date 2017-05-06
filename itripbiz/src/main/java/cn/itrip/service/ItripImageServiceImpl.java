package cn.itrip.service;
import cn.itrip.dao.ItripImageMapper;
import cn.itrip.beans.pojo.ItripImage;
import cn.itrip.beans.pojo.ItripImageExample;
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
public class ItripImageServiceImpl implements IItripImageService {

    @Autowired
    private ItripImageMapper itripImageMapper;

    @Autowired
    private SelectService<ItripImage> selectService;

    public int saveOrUpdateItripImage(ItripImage itripImage) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(itripImage.getId())){
            itripImage.setModifyDate(new Date());
            flag=itripImageMapper.updateByPrimaryKeySelective(itripImage);
        }else{
            itripImage.setCreationDate(new Date());
            flag=itripImageMapper.insert(itripImage);
        }
        return flag;
    }

    public ItripImage queryItripImageById(Long id) throws Exception{
        return itripImageMapper.selectByPrimaryKey(id);
    }

    public int removeItripImageByIds(String ids)throws Exception{
        ItripImageExample itripImageExample=new ItripImageExample();
        List<Long> idsList=new ArrayList<Long>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(Long.parseLong(idsArray[i]));
        }
        itripImageExample.createCriteria().andIdIn(idsList);
        int flag=itripImageMapper.deleteByExample(itripImageExample);
        return flag;
    }

    public List<ItripImage> queryItripImageList(ItripImageExample example)throws Exception{
        return itripImageMapper.selectByExample(example);
    }

    public Page<ItripImage> queryItripImagePage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "ItripImage.getItripImageCount";
        String listSqlId = "ItripImage.getItripImagePage";
        Page<ItripImage> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }
}

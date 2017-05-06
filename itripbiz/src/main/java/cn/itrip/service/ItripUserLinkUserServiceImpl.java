package cn.itrip.service;
import cn.itrip.dao.ItripUserLinkUserMapper;
import cn.itrip.beans.pojo.ItripUserLinkUser;
import cn.itrip.beans.pojo.ItripUserLinkUserExample;
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
public class ItripUserLinkUserServiceImpl implements IItripUserLinkUserService {

    @Autowired
    private ItripUserLinkUserMapper itripUserLinkUserMapper;

    @Autowired
    private SelectService<ItripUserLinkUser> selectService;

    public int saveOrUpdateItripUserLinkUser(ItripUserLinkUser itripUserLinkUser) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(itripUserLinkUser.getId())){
            itripUserLinkUser.setModifyDate(new Date());
            flag=itripUserLinkUserMapper.updateByPrimaryKeySelective(itripUserLinkUser);
        }else{
            itripUserLinkUser.setCreationDate(new Date());
            flag=itripUserLinkUserMapper.insert(itripUserLinkUser);
        }
        return flag;
    }

    public ItripUserLinkUser queryItripUserLinkUserById(Long id) throws Exception{
        return itripUserLinkUserMapper.selectByPrimaryKey(id);
    }

    public int removeItripUserLinkUserByIds(String ids)throws Exception{
        ItripUserLinkUserExample itripUserLinkUserExample=new ItripUserLinkUserExample();
        List<Long> idsList=new ArrayList<Long>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(Long.parseLong(idsArray[i]));
        }
        itripUserLinkUserExample.createCriteria().andIdIn(idsList);
        int flag=itripUserLinkUserMapper.deleteByExample(itripUserLinkUserExample);
        return flag;
    }

    public List<ItripUserLinkUser> queryItripUserLinkUserList(ItripUserLinkUserExample example)throws Exception{
        return itripUserLinkUserMapper.selectByExample(example);
    }

    public Page<ItripUserLinkUser> queryItripUserLinkUserPage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "ItripUserLinkUser.getItripUserLinkUserCount";
        String listSqlId = "ItripUserLinkUser.getItripUserLinkUserPage";
        Page<ItripUserLinkUser> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }
}

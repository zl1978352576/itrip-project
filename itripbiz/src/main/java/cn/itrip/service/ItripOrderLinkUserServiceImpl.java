package cn.itrip.service;
import cn.itrip.dao.ItripOrderLinkUserMapper;
import cn.itrip.beans.pojo.ItripOrderLinkUser;
import cn.itrip.beans.pojo.ItripOrderLinkUserExample;
import cn.itrip.service.common.SelectService;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ItripOrderLinkUserServiceImpl implements IItripOrderLinkUserService {

    @Autowired
    private ItripOrderLinkUserMapper itripOrderLinkUserMapper;

    @Autowired
    private SelectService<ItripOrderLinkUser> selectService;

    public int saveOrUpdateItripOrderLinkUser(ItripOrderLinkUser itripOrderLinkUser) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(itripOrderLinkUser.getId())){
            flag=itripOrderLinkUserMapper.updateByPrimaryKeySelective(itripOrderLinkUser);
        }else{
            flag=itripOrderLinkUserMapper.insert(itripOrderLinkUser);
        }
        return flag;
    }

    public ItripOrderLinkUser queryItripOrderLinkUserById(Long id) throws Exception{
        return itripOrderLinkUserMapper.selectByPrimaryKey(id);
    }

    public int removeItripOrderLinkUserByIds(String ids)throws Exception{
        ItripOrderLinkUserExample itripOrderLinkUserExample=new ItripOrderLinkUserExample();
        List<Long> idsList=new ArrayList<Long>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(Long.parseLong(idsArray[i]));
        }
        itripOrderLinkUserExample.createCriteria().andIdIn(idsList);
        int flag=itripOrderLinkUserMapper.deleteByExample(itripOrderLinkUserExample);
        return flag;
    }

    public List<ItripOrderLinkUser> queryItripOrderLinkUserList(ItripOrderLinkUserExample example)throws Exception{
        return itripOrderLinkUserMapper.selectByExample(example);
    }

    public Page<ItripOrderLinkUser> queryItripOrderLinkUserPage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "ItripOrderLinkUser.getItripOrderLinkUserCount";
        String listSqlId = "ItripOrderLinkUser.getItripOrderLinkUserPage";
        Page<ItripOrderLinkUser> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }
}

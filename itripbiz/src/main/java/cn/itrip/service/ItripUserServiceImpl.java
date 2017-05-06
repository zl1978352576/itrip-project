package cn.itrip.service;
import cn.itrip.dao.ItripUserMapper;
import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.beans.pojo.ItripUserExample;
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
public class ItripUserServiceImpl implements IItripUserService {

    @Autowired
    private ItripUserMapper itripUserMapper;

    @Autowired
    private SelectService<ItripUser> selectService;

    public int saveOrUpdateItripUser(ItripUser itripUser) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(itripUser.getId())){
            itripUser.setModifyDate(new Date());
            flag=itripUserMapper.updateByPrimaryKeySelective(itripUser);
        }else{
            itripUser.setCreationDate(new Date());
            flag=itripUserMapper.insert(itripUser);
        }
        return flag;
    }

    public ItripUser queryItripUserById(Long id) throws Exception{
        return itripUserMapper.selectByPrimaryKey(id);
    }

    public int removeItripUserByIds(String ids)throws Exception{
        ItripUserExample itripUserExample=new ItripUserExample();
        List<Long> idsList=new ArrayList<Long>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(Long.parseLong(idsArray[i]));
        }
        itripUserExample.createCriteria().andIdIn(idsList);
        int flag=itripUserMapper.deleteByExample(itripUserExample);
        return flag;
    }

    public List<ItripUser> queryItripUserList(ItripUserExample example)throws Exception{
        return itripUserMapper.selectByExample(example);
    }

    public Page<ItripUser> queryItripUserPage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "ItripUser.getItripUserCount";
        String listSqlId = "ItripUser.getItripUserPage";
        Page<ItripUser> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }
}

package cn.itrip.service.itripUserLinkUser;
import cn.itrip.dao.itripUserLinkUser.ItripUserLinkUserMapper;
import cn.itrip.beans.pojo.ItripUserLinkUser;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ItripUserLinkUserServiceImpl implements ItripUserLinkUserService {

    @Resource
    private ItripUserLinkUserMapper itripUserLinkUserMapper;

    public ItripUserLinkUser getItripUserLinkUserById(Long id)throws Exception{
        return itripUserLinkUserMapper.getItripUserLinkUserById(id);
    }

    public List<ItripUserLinkUser>	getItripUserLinkUserListByMap(Map<String,Object> param)throws Exception{
        return itripUserLinkUserMapper.getItripUserLinkUserListByMap(param);
    }

    public Integer getItripUserLinkUserCountByMap(Map<String,Object> param)throws Exception{
        return itripUserLinkUserMapper.getItripUserLinkUserCountByMap(param);
    }

    public Integer itriptxAddItripUserLinkUser(ItripUserLinkUser itripUserLinkUser)throws Exception{
            itripUserLinkUser.setCreationDate(new Date());
            return itripUserLinkUserMapper.insertItripUserLinkUser(itripUserLinkUser);
    }

    public Integer itriptxModifyItripUserLinkUser(ItripUserLinkUser itripUserLinkUser)throws Exception{
        itripUserLinkUser.setModifyDate(new Date());
        return itripUserLinkUserMapper.updateItripUserLinkUser(itripUserLinkUser);
    }

    public Integer itriptxDeleteItripUserLinkUserById(Long id)throws Exception{
        return itripUserLinkUserMapper.deleteItripUserLinkUserById(id);
    }

}

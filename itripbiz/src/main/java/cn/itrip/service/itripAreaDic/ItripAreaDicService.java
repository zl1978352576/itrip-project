package cn.itrip.service.itripAreaDic;
import cn.itrip.beans.pojo.ItripAreaDic;
import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Map;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripAreaDicService {

    public ItripAreaDic getItripAreaDicById(Long id)throws Exception;

    public List<ItripAreaDic>	getItripAreaDicListByMap(Map<String,Object> param)throws Exception;

    public Integer getItripAreaDicCountByMap(Map<String,Object> param)throws Exception;

    public Integer insertItripAreaDic(ItripAreaDic itripAreaDic)throws Exception;

    public Integer updateItripAreaDic(ItripAreaDic itripAreaDic)throws Exception;

    public Integer deleteItripAreaDicById(Long id)throws Exception;

}

package cn.itrip.service;
import cn.itrip.beans.pojo.ItripAreaDic;
import java.util.List;
import java.util.Map;
import cn.itrip.beans.pojo.ItripAreaDicExample;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface IItripAreaDicService {

    public int saveOrUpdateItripAreaDic(ItripAreaDic obj)throws Exception;

    public ItripAreaDic queryItripAreaDicById(Long id)throws Exception;

    public int removeItripAreaDicByIds(String ids)throws Exception;

    public List<ItripAreaDic> queryItripAreaDicList(ItripAreaDicExample example)throws Exception;

    public Page<ItripAreaDic> queryItripAreaDicPage(Map params)throws Exception;
}

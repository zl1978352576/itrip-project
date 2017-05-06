package cn.itrip.service;
import cn.itrip.beans.pojo.ItripLabelDic;
import java.util.List;
import java.util.Map;
import cn.itrip.beans.pojo.ItripLabelDicExample;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface IItripLabelDicService {

    public int saveOrUpdateItripLabelDic(ItripLabelDic obj)throws Exception;

    public ItripLabelDic queryItripLabelDicById(Long id)throws Exception;

    public int removeItripLabelDicByIds(String ids)throws Exception;

    public List<ItripLabelDic> queryItripLabelDicList(ItripLabelDicExample example)throws Exception;

    public Page<ItripLabelDic> queryItripLabelDicPage(Map params)throws Exception;
}

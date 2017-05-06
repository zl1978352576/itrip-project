package cn.itrip.service;
import cn.itrip.beans.pojo.ItripImage;
import java.util.List;
import java.util.Map;
import cn.itrip.beans.pojo.ItripImageExample;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface IItripImageService {

    public int saveOrUpdateItripImage(ItripImage obj)throws Exception;

    public ItripImage queryItripImageById(Long id)throws Exception;

    public int removeItripImageByIds(String ids)throws Exception;

    public List<ItripImage> queryItripImageList(ItripImageExample example)throws Exception;

    public Page<ItripImage> queryItripImagePage(Map params)throws Exception;
}

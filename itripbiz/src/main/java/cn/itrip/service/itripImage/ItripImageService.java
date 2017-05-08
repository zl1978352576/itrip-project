package cn.itrip.service.itripImage;
import cn.itrip.beans.pojo.ItripImage;
import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Map;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripImageService {

    public ItripImage getItripImageById(Long id)throws Exception;

    public List<ItripImage>	getItripImageListByMap(Map<String,Object> param)throws Exception;

    public Integer getItripImageCountByMap(Map<String,Object> param)throws Exception;

    public Integer insertItripImage(ItripImage itripImage)throws Exception;

    public Integer updateItripImage(ItripImage itripImage)throws Exception;

    public Integer deleteItripImageById(Long id)throws Exception;

}

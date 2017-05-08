package cn.itrip.service.itripImage;
import cn.itrip.dao.itripImage.ItripImageMapper;
import cn.itrip.beans.pojo.ItripImage;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ItripImageServiceImpl implements ItripImageService {

    @Resource
    private ItripImageMapper itripImageMapper;

    public ItripImage getItripImageById(Long id)throws Exception{
        return itripImageMapper.getItripImageById(id);
    }

    public List<ItripImage>	getItripImageListByMap(Map<String,Object> param)throws Exception{
        return itripImageMapper.getItripImageListByMap(param);
    }

    public Integer getItripImageCountByMap(Map<String,Object> param)throws Exception{
        return itripImageMapper.getItripImageCountByMap(param);
    }

    public Integer insertItripImage(ItripImage itripImage)throws Exception{
            itripImage.setCreationDate(new Date());
            return itripImageMapper.updateItripImage(itripImage);
    }

    public Integer updateItripImage(ItripImage itripImage)throws Exception{
        itripImage.setModifyDate(new Date());
        return itripImageMapper.updateItripImage(itripImage);
    }

    public Integer deleteItripImageById(Long id)throws Exception{
        return itripImageMapper.deleteItripImageById(id);
    }

}

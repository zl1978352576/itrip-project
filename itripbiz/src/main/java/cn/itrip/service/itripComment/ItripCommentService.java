package cn.itrip.service.itripComment;
import cn.itrip.beans.pojo.ItripComment;
import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Map;

import cn.itrip.beans.pojo.ItripImage;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripCommentService {

    public ItripComment getItripCommentById(Long id)throws Exception;

    public List<ItripComment>	getItripCommentListByMap(Map<String,Object> param)throws Exception;

    public Integer getItripCommentCountByMap(Map<String,Object> param)throws Exception;

    public boolean itriptxAddItripComment(ItripComment itripComment, List<ItripImage> itripImages)throws Exception;

    public Integer ModifyItripComment(ItripComment itripComment)throws Exception;

    public Integer DeleteItripCommentById(Long id)throws Exception;

    public Page<ItripComment> queryItripCommentPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception;
}

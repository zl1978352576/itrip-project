package cn.itrip.service.itripComment;
import cn.itrip.beans.pojo.ItripComment;
import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Map;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripCommentService {

    public ItripComment getItripCommentById(Long id)throws Exception;

    public List<ItripComment>	getItripCommentListByMap(Map<String,Object> param)throws Exception;

    public Integer getItripCommentCountByMap(Map<String,Object> param)throws Exception;

    public Integer insertItripComment(ItripComment itripComment)throws Exception;

    public Integer updateItripComment(ItripComment itripComment)throws Exception;

    public Integer deleteItripCommentById(Long id)throws Exception;

}

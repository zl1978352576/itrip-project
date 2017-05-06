package cn.itrip.service;
import cn.itrip.beans.pojo.ItripComment;
import java.util.List;
import java.util.Map;
import cn.itrip.beans.pojo.ItripCommentExample;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface IItripCommentService {

    public int saveOrUpdateItripComment(ItripComment obj)throws Exception;

    public ItripComment queryItripCommentById(Long id)throws Exception;

    public int removeItripCommentByIds(String ids)throws Exception;

    public List<ItripComment> queryItripCommentList(ItripCommentExample example)throws Exception;

    public Page<ItripComment> queryItripCommentPage(Map params)throws Exception;
}

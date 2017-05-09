package cn.itrip.service.itripComment;
import cn.itrip.beans.pojo.ItripImage;
import cn.itrip.common.BigDecimalUtil;
import cn.itrip.dao.itripComment.ItripCommentMapper;
import cn.itrip.beans.pojo.ItripComment;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import cn.itrip.dao.itripImage.ItripImageMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.itrip.common.Constants;
@Service
public class ItripCommentServiceImpl implements ItripCommentService {

    @Resource
    private ItripCommentMapper itripCommentMapper;

    @Resource
    private ItripImageMapper itripImageMapper;

    public ItripComment getItripCommentById(Long id)throws Exception{
        return itripCommentMapper.getItripCommentById(id);
    }

    public List<ItripComment>	getItripCommentListByMap(Map<String,Object> param)throws Exception{
        return itripCommentMapper.getItripCommentListByMap(param);
    }

    public Integer getItripCommentCountByMap(Map<String,Object> param)throws Exception{
        return itripCommentMapper.getItripCommentCountByMap(param);
    }

    public Long addItripComment(ItripComment obj) throws Exception {
        //计算综合评分，综合评分=(设施+卫生+位置+服务)/4
        float score = 0;
        int sum = obj.getFacilitiesScore()+obj.getHygieneScore()+obj.getPositionScore()+obj.getServiceScore();
        score = BigDecimalUtil.OperationASMD(sum,4, BigDecimalUtil.BigDecimalOprations.divide,1, BigDecimal.ROUND_DOWN).floatValue();
        //对结果四舍五入
        obj.setScore(Math.round(score));
        return itripCommentMapper.insertItripComment(obj);
    }

    public boolean itriptxAddItripComment(ItripComment obj, List<ItripImage> itripImages)throws Exception{
        if(null != obj ){
            Long commentId = this.addItripComment(obj);
            if(null != itripImages && itripImages.size() > 0 && commentId > 0){
                for (ItripImage itripImage:itripImages) {
                    itripImage.setTargetId(commentId.longValue());
                    itripImageMapper.insertItripImage(itripImage);
                }
            }
            return true;
        }
        return false;
    }

    public Integer ModifyItripComment(ItripComment itripComment)throws Exception{
        itripComment.setModifyDate(new Date());
        return itripCommentMapper.updateItripComment(itripComment);
    }

    public Integer DeleteItripCommentById(Long id)throws Exception{
        return itripCommentMapper.deleteItripCommentById(id);
    }

    public Page<ItripComment> queryItripCommentPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = itripCommentMapper.getItripCommentCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<ItripComment> itripCommentList = itripCommentMapper.getItripCommentListByMap(param);
        page.setRows(itripCommentList);
        return page;
    }

}

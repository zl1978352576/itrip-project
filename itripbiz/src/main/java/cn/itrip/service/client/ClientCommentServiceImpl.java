package cn.itrip.service.client;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import cn.itrip.beans.pojo.ItripImage;
import cn.itrip.beans.vo.comment.ItripAddCommentVO;
import cn.itrip.common.BigDecimalUtil;
import cn.itrip.common.Page;
import cn.itrip.dao.ItripCommentMapper;
import cn.itrip.service.IItripCommentService;
import cn.itrip.service.IItripImageService;
import cn.itrip.service.ItripImageServiceImpl;
import cn.itrip.service.common.SelectService;
import cn.itrip.beans.vo.comment.ITripCommentScoreVo;
import cn.itrip.beans.vo.comment.ITripCommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itrip.beans.pojo.ItripComment;
import cn.itrip.service.ItripCommentServiceImpl;

import javax.annotation.Resource;

@Service
public class ClientCommentServiceImpl implements IClientCommentService {

	@Autowired
	private IItripCommentService commentService;
	@Autowired
	private IItripImageService iItripImageService;

	@Autowired
	private SelectService<ITripCommentVo> commentSelectService;

	@Override
	public Long addItripComment(ItripComment obj) throws Exception {
		//计算综合评分，综合评分=(设施+卫生+位置+服务)/4
		float score = 0;
		int sum = obj.getFacilitiesScore()+obj.getHygieneScore()+obj.getPositionScore()+obj.getServiceScore();
		score = BigDecimalUtil.OperationASMD(sum,4, BigDecimalUtil.BigDecimalOprations.divide,1, BigDecimal.ROUND_DOWN).floatValue();
		//对结果四舍五入
		obj.setScore(Math.round(score));
		return commentService.saveOrUpdateItripComment(obj);
	}

    @Override
    public boolean itriptxAddItripComment(ItripComment obj, List<ItripImage> itripImages) throws Exception {
        if(null != obj ){
            Long commentId = this.addItripComment(obj);
            if(null != itripImages && itripImages.size() > 0 && commentId > 0){
                for (ItripImage itripImage:itripImages) {
                    itripImage.setTargetId(commentId);
                    iItripImageService.saveOrUpdateItripImage(itripImage);
                }
            }
            return true;
        }
        return false;
    }



	@Override
	public Page<ITripCommentVo> queryItripCommentList(Map<String, Object> param)
			throws Exception {
//		ItripCommentExample itripCommentExample = new ItripCommentExample();
//		Integer isHavingImg = null;
//		Integer isOk = null;
//		//如果有图片则添加有图片作为查询条件
//		if(!EmptyUtils.isEmpty(param.get("isHavingImg")))
//		{
//			isHavingImg = (Integer)param.get("isHavingImg");
//			if(isHavingImg == 1){
//				itripCommentExample.createCriteria().andIsHavingImgEqualTo(isHavingImg);
//			}
//		}
//		//如果是否满意有值，则在添加条件
//		if(!EmptyUtils.isEmpty(obj.getIsOk()))
//		{
//			isOk = obj.getIsOk();
//			itripCommentExample.createCriteria().andIsHavingImgEqualTo(isOk);
//		}
//		return commentService.queryItripCommentList(itripCommentExample);
		Page<ITripCommentVo> commentPage=commentSelectService.getPage("ItripComment.getItripCommentCount", "ItripComment.getItripCommentPage", param);
		return commentPage;
	}

    public ITripCommentScoreVo getAvgAndTotalScore(Integer hotelId) throws Exception {
        return commentService.getAvgAndTotalScore(hotelId);
    }


}

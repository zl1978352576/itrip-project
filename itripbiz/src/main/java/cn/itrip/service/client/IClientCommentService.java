package cn.itrip.service.client;

import java.util.List;
import java.util.Map;

import cn.itrip.beans.pojo.ItripImage;
import cn.itrip.beans.vo.comment.ItripAddCommentVO;
import cn.itrip.common.Page;
import cn.itrip.beans.pojo.ItripComment;
import cn.itrip.beans.vo.comment.ITripCommentScoreVo;
import cn.itrip.beans.vo.comment.ITripCommentVo;

public interface IClientCommentService {

	/**
	 * 添加点评
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Long addItripComment(ItripComment obj) throws Exception;

	/**
	 * 添加点评-add by hanlu
	 * @param obj
	 * @param itripImages
	 * @return
	 * @throws Exception
	 */
	public boolean itriptxAddItripComment(ItripComment obj, List<ItripImage> itripImages)throws  Exception;




	/**
	 * 根据酒店的id查询所有的点评信息
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Page<ITripCommentVo> queryItripCommentList(Map<String, Object> param) throws Exception;

	/**
	 * 根据酒店的id查询并计算所有点评的位置、设施、服务、卫生和综合评分
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	public ITripCommentScoreVo getAvgAndTotalScore(Integer hotelId) throws Exception;
}

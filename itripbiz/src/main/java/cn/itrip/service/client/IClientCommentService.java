package cn.itrip.service.client;

import java.util.Map;

import cn.itrip.common.Page;
import cn.itrip.beans.pojo.ItripComment;
import cn.itrip.beans.vo.ITripCommentScoreVo;
import cn.itrip.beans.vo.ITripCommentVo;

public interface IClientCommentService {

	/**
	 * 添加点评
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public int addItripComment(ItripComment obj) throws Exception;

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

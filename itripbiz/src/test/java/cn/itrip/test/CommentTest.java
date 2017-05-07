package cn.itrip.test;

import java.util.*;

import cn.itrip.common.Page;
import cn.itrip.beans.vo.comment.ITripCommentScoreVo;
import cn.itrip.beans.vo.comment.ITripCommentVo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.itrip.beans.pojo.ItripComment;
import cn.itrip.service.client.IClientCommentService;

public class CommentTest {

    @Test
    public void test() {
        System.out.println("Not yet implemented");
    }

    @Test
    public void testAddItripComment() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        IClientCommentService clientCommentServiceImpl =
                (IClientCommentService) context.getBean("clientCommentServiceImpl");
        ItripComment comment = new ItripComment();
        comment.setHotelId(1L);
        comment.setProductId(1L);
        comment.setProductType(1);
        comment.setUserId(1L);
        comment.setIsHavingImg(1);
        comment.setPositionScore(3);
        comment.setFacilitiesScore(3);
        comment.setServiceScore(4);
        comment.setHygieneScore(3);
        comment.setTripMode("1");
        comment.setIsOk(1);
        comment.setCreationDate(new Date());
        comment.setCreatedBy(1l);
        comment.setModifyDate(new Date());
        comment.setModifiedBy(1l);
        comment.setContent("1231231");

        try {
            Long i = clientCommentServiceImpl.addItripComment(comment);
            System.out.println("添加点评的数量为：" + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryItripCommentList() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        IClientCommentService clientCommentServiceImpl =
                (IClientCommentService) context.getBean("clientCommentServiceImpl");
        Page<ITripCommentVo> commentList = new Page<ITripCommentVo>();
        Map<String, Object> param = new HashMap<String, Object>();

        try {
            commentList = clientCommentServiceImpl.queryItripCommentList(param);
            int i = 0;
//			for(ITripCommentVo itripCommentVo : commentList){
//				System.out.println("=================== "+i+" ===========");
//				System.out.println(itripCommentVo.getHotelName());
//				System.out.println(itripCommentVo.getId());
//				System.out.println(itripCommentVo.getCreationDate());
//				i++;
//			}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAvgAndTotalScore() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        IClientCommentService clientCommentServiceImpl =
                (IClientCommentService) context.getBean("clientCommentServiceImpl");
        ItripComment comment = new ItripComment();
        comment.setHotelId(1L);
        ITripCommentScoreVo commentScoreVo = new ITripCommentScoreVo();
        try {
            commentScoreVo = clientCommentServiceImpl.getAvgAndTotalScore(1);
            System.out.println("位置得分：" + commentScoreVo.getAvgPositionScore());
            System.out.println("设施得分：" + commentScoreVo.getAvgFacilitiesScore());
            System.out.println("服务得分：" + commentScoreVo.getAvgServiceScore());
            System.out.println("卫生得分：" + commentScoreVo.getAvgHygieneScore());
            System.out.println("综合得分：" + commentScoreVo.getAvgScore());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	@Test
	public void test2() {
		System.out.println("Not 222 implemented");
	}

}

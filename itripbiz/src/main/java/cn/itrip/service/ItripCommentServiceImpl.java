package cn.itrip.service;
import cn.itrip.beans.vo.comment.ITripCommentScoreVo;
import cn.itrip.dao.ItripCommentMapper;
import cn.itrip.beans.pojo.ItripComment;
import cn.itrip.beans.pojo.ItripCommentExample;
import cn.itrip.service.common.SelectService;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ItripCommentServiceImpl implements IItripCommentService {

    @Autowired
    private ItripCommentMapper itripCommentMapper;

    @Autowired
    private SelectService<ItripComment> selectService;

    public Long saveOrUpdateItripComment(ItripComment itripComment) throws Exception{
        Long flag=0l;
        if(EmptyUtils.isNotEmpty(itripComment.getId())){
            itripComment.setModifyDate(new Date());
            flag=itripCommentMapper.updateByPrimaryKeySelective(itripComment);
        }else{
            itripComment.setCreationDate(new Date());
            flag=itripCommentMapper.insert(itripComment);
        }
        return flag;
    }

    public ItripComment queryItripCommentById(Long id) throws Exception{
        return itripCommentMapper.selectByPrimaryKey(id);
    }

    public int removeItripCommentByIds(String ids)throws Exception{
        ItripCommentExample itripCommentExample=new ItripCommentExample();
        List<Long> idsList=new ArrayList<Long>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(Long.parseLong(idsArray[i]));
        }
        itripCommentExample.createCriteria().andIdIn(idsList);
        int flag=itripCommentMapper.deleteByExample(itripCommentExample);
        return flag;
    }

    public List<ItripComment> queryItripCommentList(ItripCommentExample example)throws Exception{
        return itripCommentMapper.selectByExample(example);
    }

    public Page<ItripComment> queryItripCommentPage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "ItripComment.getItripCommentCount";
        String listSqlId = "ItripComment.getItripCommentPage";
        Page<ItripComment> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }

    @Override
    public ITripCommentScoreVo getAvgAndTotalScore(Integer hotelId) throws Exception {
        return itripCommentMapper.getCommentAvgScore(hotelId);
    }
}

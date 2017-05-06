package cn.itrip.service.common;
import cn.itrip.common.Constants;
import cn.itrip.common.Page;
import cn.itrip.dao.common.GenericDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import cn.itrip.common.StringUtils;
@Service
public class SelectService<T> {

    @Autowired
    private GenericDAOImpl genericDAO;

    public Page<T> getPage(String countStatement, String dataStatement, Object parameter, int curPage) {
        return genericDAO.getPage(countStatement, dataStatement, parameter, curPage);
    }

    public Page<T> getPage(String countStatement, String dataStatement, Object parameter, int curPage, int pageSize) {

        return genericDAO.getPage(countStatement, dataStatement, parameter, curPage, pageSize);
    }

    public Page<T> getPage(String countStatement, String dataStatement, Object parameter, Page page) {
        return genericDAO.getPage(countStatement, dataStatement, parameter, page);
    }

    public Page<T> getPage(Class clazz, Object parameter, int curPage) {
        return genericDAO.getPage(clazz, parameter, curPage);
    }

    public Page<T> getPage(Class clazz, Object parameter, int curPage, int pageSize) {
        return genericDAO.getPage(clazz, parameter, curPage, pageSize);
    }

    public Page<T> getPage(Class clazz, Object parameter, Page page) {
        return genericDAO.getPage(clazz, parameter, page);
    }

    public Object list(String string, Map<String, Object> map) {
        Object obj = genericDAO.list(string, map);
        return obj;
    }

    public Object object(String string, Object parameter) {
        Object obj = genericDAO.object(string, parameter);
        return obj;
    }

    /***
     * add by zzshang 专门用于easy ui 的分页
     *
     * @param countStatement
     * @param dataStatement
     * @param parameter
     * @return
     */
    public Page<T> getPage(String countStatement, String dataStatement, Object parameter) {
        Map params = null;
        if (parameter instanceof Map) {
            params = (Map) parameter;
        }
        Integer page = ((params.get("page") == null || params.get("page") == "") ? Constants.DEFAULT_PAGE_NO : Integer.valueOf((StringUtils.objectToString(params.get("page")))));
        Integer rows = ((params.get("rows") == null || params.get("rows") == "") ? Constants.DEFAULT_PAGE_SIZE : Integer.valueOf((StringUtils.objectToString(params.get("rows")))));
        return genericDAO.getPage(countStatement, dataStatement, parameter, page, rows);
    }

    public Page<T> getPageByLimit(String countStatement,String queryStatement,Map params) {
        Page<T> page = new Page<T>();
        Integer pageNo = ((params.get("page") == null || params.get("page") == "") ? Constants.DEFAULT_PAGE_NO : Integer.valueOf((StringUtils.objectToString(params.get("page")))));
        Integer rows = ((params.get("rows") == null || params.get("rows") == "") ? Constants.DEFAULT_PAGE_SIZE : Integer.valueOf((StringUtils.objectToString(params.get("rows")))));
        //计算数目
        Integer total = genericDAO.count(countStatement, params);
        int start = (pageNo-1)*rows;
        params.put("beginPos", start);
        params.put("rows", rows);
        List<T> list = genericDAO.list(queryStatement, params);
        page.setRows(list);
        page.setTotal(total);
        return page;
    }

    public Integer getCount(String countStatement,Map params){
        Integer total = genericDAO.count(countStatement, params);
        return total;
    }
}

package cn.itrip.service.client;

import cn.itrip.beans.pojo.ItripImage;

import java.util.List;

/**
 * Created by zezhong.shang on 17-4-27.
 */
public interface ClientImageService {

    public List<ItripImage> queryItripImageList(Integer type, Long targetId);
}

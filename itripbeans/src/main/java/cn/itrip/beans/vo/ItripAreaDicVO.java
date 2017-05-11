package cn.itrip.beans.vo;

import java.io.Serializable;

/**
 * Created by zezhong.shang on 17-5-11.
 */
public class ItripAreaDicVO implements Serializable{
    private Long id;
    private String name;
    private String areaNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaNo() {
        return areaNo;
    }

    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo;
    }
}

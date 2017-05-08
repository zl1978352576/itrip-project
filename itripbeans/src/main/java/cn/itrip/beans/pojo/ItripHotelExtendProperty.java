package cn.itrip.beans.pojo;

import java.io.Serializable;
import java.util.Date;
public class ItripHotelExtendProperty implements Serializable {

            private Long id;
            private Long hotelId;
            private Long extendPropertyId;

            public void setId (Long  id){
                this.id=id;
            }

            public  Long getId(){
                return this.id;
            }
            public void setHotelId (Long  hotelId){
                this.hotelId=hotelId;
            }

            public  Long getHotelId(){
                return this.hotelId;
            }
            public void setExtendPropertyId (Long  extendPropertyId){
                this.extendPropertyId=extendPropertyId;
            }

            public  Long getExtendPropertyId(){
                return this.extendPropertyId;
            }

}

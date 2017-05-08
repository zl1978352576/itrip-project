package cn.itrip.beans.pojo;

import java.io.Serializable;
import java.util.Date;
public class ItripHotelKeyword implements Serializable {

            private Long id;
            private Long hotelId;
            private Long keywordId;

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
            public void setKeywordId (Long  keywordId){
                this.keywordId=keywordId;
            }

            public  Long getKeywordId(){
                return this.keywordId;
            }

}

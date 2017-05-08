package cn.itrip.beans.pojo;

import java.io.Serializable;
import java.util.Date;
public class ItripOrderLinkUser implements Serializable {

            private Long id;
            private Long orderId;
            private Long linkUserId;

            public void setId (Long  id){
                this.id=id;
            }

            public  Long getId(){
                return this.id;
            }
            public void setOrderId (Long  orderId){
                this.orderId=orderId;
            }

            public  Long getOrderId(){
                return this.orderId;
            }
            public void setLinkUserId (Long  linkUserId){
                this.linkUserId=linkUserId;
            }

            public  Long getLinkUserId(){
                return this.linkUserId;
            }

}

//package uow.codetest.tab.design.model;
//
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
///**
// * Item Entity
// *
// * @author 	Tab Tu
// * @update  Tab Tu on Oct.16 2018
// * @since	1.0
// *
// */
//
//@Entity(name = "Item")
//@Table(name = "db_shop_item")
//@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
//public class Item extends Entitys implements Serializable {
//
//    @Id
//    @GeneratedValue(generator = "jpa-uuid")
//    private String id;
//
//    private int rate;
//
//    public Item() {
//
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public int getRate() {
//        return rate;
//    }
//
//    public void setRate(int rate) {
//        this.rate = rate;
//    }
//}

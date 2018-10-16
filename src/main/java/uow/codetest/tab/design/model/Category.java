//package uow.codetest.tab.design.model;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
///**
// * Category Entity
// *
// * @author 	Tab Tu
// * @update  Tab Tu on Oct.16 2018
// * @since	1.0
// *
// */
//
//@Entity(name = "Category")
//@Table(name = "db_shop_category")
//public class Category extends Entitys implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//    @Column(nullable = false)
//    private String name;
//    private int sort;
//
//    public Category() {
//
//    }
//
//    public Category(int cate_id) {
//        this.id = cate_id;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getSort() {
//        return sort;
//    }
//
//    public void setSort(int sort) {
//        this.sort = sort;
//    }
//}
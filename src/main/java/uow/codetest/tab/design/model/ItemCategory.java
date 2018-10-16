package uow.codetest.tab.design.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * ItemCategory Entity
 *
 * @author 	Tab Tu
 * @update  Tab Tu on Oct.17 2018
 * @since	1.0
 *
 */

@Entity(name = "ItemCategory")
@Table(name = "db_shop_category")
public class ItemCategory extends Entitys implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    private int sort;

    public ItemCategory() {

    }

    public ItemCategory(int cate_id) {
        this.id = cate_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
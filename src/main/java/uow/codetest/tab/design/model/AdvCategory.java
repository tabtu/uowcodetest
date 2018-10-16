package uow.codetest.tab.design.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * AdvCategory Entity
 *
 * @author 	Tab Tu
 * @update  Tab Tu on Oct.17 2018
 * @since	1.0
 *
 */

@Entity(name = "AdvCategory")
@Table(name = "db_app_category")
public class AdvCategory extends Entitys implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    private int sort;

    public AdvCategory() {

    }

    public AdvCategory(int cate_id) {
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
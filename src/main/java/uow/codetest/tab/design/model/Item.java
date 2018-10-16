package uow.codetest.tab.design.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Item Entity
 *
 * @author 	Tab Tu
 * @update  Tab Tu on Oct.17 2018
 * @since	1.0
 *
 */

@Entity(name = "Item")
@Table(name = "db_shop_item")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Item extends Entitys implements Serializable {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name="item_cate")
    @JsonBackReference
    private ItemCategory category;

    private String name;

    public Item() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

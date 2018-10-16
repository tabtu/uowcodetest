package uow.codetest.tab.design.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Health Data Entity
 *
 * @author 	Tab Tu
 * @update  Tab Tu on Oct.17 2018
 * @since	1.0
 *
 */

@Entity(name = "MemberShip")
@Table(name = "db_user_membership")
public class HealthData extends Entitys implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;

    public HealthData() {

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
}
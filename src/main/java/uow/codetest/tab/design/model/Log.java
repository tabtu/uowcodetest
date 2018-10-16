package uow.codetest.tab.design.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Log Entity
 *
 * @author 	Tab Tu
 * @update  Tab Tu on Oct.16 2018
 * @since	1.0
 *
 */

@Entity(name = "Log")
@Table(name = "db_user_log")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Log extends Entitys implements Serializable {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name="lg_user")
    @JsonBackReference
    private User lguser;
    @Column(nullable = false)
    private Date lgtime;
    @Column(nullable = false)
    private String operation;

    public Log() {

    }

    public Log(User u, Date t, String op) {
        this.lguser = u;
        this.lgtime = t;
        this.operation = op;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getLguser() {
        return lguser;
    }

    @JsonBackReference
    public void setLguser(User lguser) {
        this.lguser = lguser;
    }

    public Date getLgtime() {
        return lgtime;
    }

    public void setLgtime(Date lgtime) {
        this.lgtime = lgtime;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
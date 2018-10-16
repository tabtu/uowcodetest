package uow.codetest.tab.design.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User Entity
 *
 * @author 	Tab Tu
 * @update  Tab Tu on Oct.16 2018
 * @since	1.0
 *
 * TODO: 1, a process to check membership status daily, update User.is_member
 */

@Entity(name = "User")
@Table(name = "db_user_user")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User extends Entitys implements Serializable {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String id;  // user id, primary key.
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String telephone;
    @Column(nullable = false)
    private String password;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private boolean enabled;
    @Column(nullable = false)
    private Date createtime;
    @Column(nullable = false)
    private Date updatetime;
    private String name;
    @Column(nullable = false)
    private boolean is_member;  // membership card

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="user_member")
    private MemberShip member_ship;  // membership information

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "db_user_follow", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "follow_id"))
    @JsonBackReference
    //@JsonIgnoreProperties
    private List<User> follows = new ArrayList<>();
    @ManyToMany(mappedBy = "follows", cascade = CascadeType.ALL)
    @JsonManagedReference
    //@JsonIgnoreProperties
    private List<User> fans = new ArrayList<>();

    public User() { super(); }

    public User(String password, String id) {
        super();
        this.id = id;
        this.password = password;
    }

    public User(String password, String username, String email, String telephone) {
        super();
        this.email = email;
        this.password = password;
        this.username = username;
        this.telephone = telephone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getFollows() {
        return follows;
    }

    public void setFollows(List<User> follows) {
        this.follows = follows;
    }

    public List<User> getFans() {
        return fans;
    }

    public void setFans(List<User> fans) {
        this.fans = fans;
    }

    public boolean getIs_member() {
        return is_member;
    }

    public void setIs_member(boolean ismb) {
        this.is_member = ismb;
    }

    public MemberShip getMember_ship() {
        return member_ship;
    }

    public void setMember_ship(MemberShip mbsp) {
        this.member_ship = mbsp;
    }

}
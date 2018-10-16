//package uow.codetest.tab.design.model;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Date;
//
///**
// * News
// *
// * @author 	Tab Tu
// * @update  Tab Tu on Oct.16 2018
// * @since	1.0
// *
// */
//
//@Entity(name = "News")
//@Table(name = "db_app_news")
//public class News extends Entitys implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//    @Column(nullable = false)
//    private Date updatedate;
//    @Column(nullable = false)
//    private String title;
//    @Column(length = 65535, columnDefinition = "Text")
//    private String text;
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "news_city")
//    @JsonBackReference
//    private String background;
//    private String author;
//    private boolean home;
//
//    public News() {
//
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public Date getUpdatedate() {
//        return updatedate;
//    }
//
//    public void setUpdatedate(Date updatedate) {
//        this.updatedate = updatedate;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getBackground() {
//        return background;
//    }
//
//    public void setBackground(String background) {
//        this.background = background;
//    }
//
//    public boolean getHome() {
//        return home;
//    }
//
//    public void setHome(boolean home) {
//        this.home = home;
//    }
//}
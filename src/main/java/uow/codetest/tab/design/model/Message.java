package uow.codetest.tab.design.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Message Entity
 *
 * @author 	Tab Tu
 * @update  Tab Tu on Oct.16 2018
 * @since	1.0
 *
 */

@Entity(name = "Message")
@Table(name = "db_user_message")
public class Message extends Entitys implements Serializable {

    @EmbeddedId
    private Msg id;
    @Column(nullable = false)
    private boolean isread;
    @Column(length = 65535, columnDefinition="Text")
    private String text;
    private Date logtime;

    public Message() {

    }

    public Message(Msg msd, String txt) {
        this.id = msd;
        this.text = txt;
        this.isread = false;
        this.logtime = new Date();
    }

    public Msg getId() {
        return id;
    }

    public void setId(Msg id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getIsread() {
        return isread;
    }

    public void setIsread(boolean isread) {
        this.isread = isread;
    }

    public Date getLogtime() {
        return logtime;
    }

    public void setLogtime(Date logtime) {
        this.logtime = logtime;
    }
}
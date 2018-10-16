package uow.codetest.tab.design.model;

import javax.persistence.Embeddable;
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

@Embeddable
public class Msg implements Serializable {

    private String sender;
    private String receiver;
    private Date sendtime;

    public Msg() {

    }

    public Msg(String s, String r) {
        this.sender = s;
        this.receiver = r;
        this.sendtime = new Date();
    }

    public Msg(String s, String r, Date st) {
        this.sender = s;
        this.receiver = r;
        this.sendtime = st;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Msg other = (Msg) obj;
        if(sender == other.sender && receiver == other.receiver && sendtime == other.sendtime) {
            return true;
        } else {
            return false;
        }
    }
}


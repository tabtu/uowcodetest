package uow.codetest.tab.design.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Msgs Entity
 * Transfer to Client. Combine Message with Msg.
 *
 * @author 	Tab Tu
 * @update  Tab Tu on Oct.16 2018
 * @since	1.0
 *
 */

public class Msgs extends Entitys implements Serializable {

    private String sender;
    private String receiver;
    private Date sendtime;
    private boolean isread;
    private String text;
    private Date logtime;

    public Msgs(String s, String r, String text) {
        this.sender = s;
        this.receiver = r;
        this.sendtime = new Date();
        this.text = text;
        this.isread = false;
    }

    public Msgs(String s, String r, Date st, String text, boolean isread) {
        this.sender = s;
        this.receiver = r;
        this.sendtime = st;
        this.logtime = st;
        this.text = text;
        this.isread = isread;
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
package pojo;

import java.util.Date;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/20
 * @Description: pojo
 * @version: 1.0
 */
public class Record {
    private int id;
    private int spend;
    private int cid;//外键--分类
    private String comment;//备注
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpend() {
        return spend;
    }

    public void setSpend(int spend) {
        this.spend = spend;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Record(int id, int spend, int cid, String comment, Date date) {

        this.id = id;
        this.spend = spend;
        this.cid = cid;
        this.comment = comment;
        this.date = date;
    }
}

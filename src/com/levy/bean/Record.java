package com.levy.bean;

import java.util.Date;

/**
 * @description：Record的bean
 * @author：LevyXie
 * @create：2022-02-04 22:29
 */
public class Record {
    private int id;
    private double spend;
    private int cid;
    private String note;
    private Date date;

    public Record() {
    }

    public Record(int id, double spend, int cid, String note, Date date) {
        this.id = id;
        this.spend = spend;
        this.cid = cid;
        this.note = note;
        this.date = date;
    }

    public Record(double spend, int cid, String note, Date date) {
        this.spend = spend;
        this.cid = cid;
        this.note = note;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSpend() {
        return spend;
    }

    public void setSpend(double spend) {
        this.spend = spend;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", spend=" + spend +
                ", cid=" + cid +
                ", note='" + note + '\'' +
                ", date=" + date +
                '}';
    }
}

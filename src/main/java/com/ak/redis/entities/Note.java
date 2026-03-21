package com.ak.redis.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "stream_note")
public class Note implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private  String id;

    private String title;

    private String content;

    private Boolean live=false;

    private Date addDate;

    public Note(){

    }

    public Note(String id, String title, String content, Boolean live, Date addDate){
        this.id = id;
        this.title = title;
        this.content = content;
        this.live = live;
        this.addDate = addDate;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public Boolean getLive(){
        return live;
    }

    public void setLive(Boolean live){
        this.live = live;
    }

    public Date getAddDate(){
        return addDate;
    }

    public void setAddDate(Date addDate){
        this.addDate = addDate;
    }

}

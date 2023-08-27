package com.example.demo.model;

import java.io.InputStream;
import java.util.Date;

public class Beanfilms {
    private int id;
    private String name;
    private String description;
    private Date publish_date;
    private String actors;
    private int duration;
    private int ranking;
    private InputStream image;
    private int status;

    public Beanfilms() {
    }

    public Beanfilms(int id, String name, String description, Date publish_date, String actors, int duration, int ranking, InputStream image, int status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.publish_date = publish_date;
        this.actors = actors;
        this.duration = duration;
        this.ranking = ranking;
        this.image = image;
        this.status = status;
    }

    public Beanfilms(int id, String name, String description, Date publish_date, String actors, int duration, int ranking, int status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.publish_date = publish_date;
        this.actors = actors;
        this.duration = duration;
        this.ranking = ranking;
        this.status = status;
    }

    public Beanfilms(String name, String description, Date publish_date, String actors, int duration, int ranking) {
        this.name = name;
        this.description = description;
        this.publish_date = publish_date;
        this.actors = actors;
        this.duration = duration;
        this.ranking = ranking;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

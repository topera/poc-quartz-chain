package com.zp.model.deezer;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by topera on 09/07/17.
 */
@XmlRootElement
public class PlaylistDeezer {

    private Long id;
    private String title;
    private String picture;
    private String picture_medium;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture_medium() {
        return picture_medium;
    }

    public void setPicture_medium(String picture_medium) {
        this.picture_medium = picture_medium;
    }
}
package com.topera.hello.model.deezer;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by topera on 09/07/17.
 */
@XmlRootElement
class Playlist {

    private Long id;
    private String title;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
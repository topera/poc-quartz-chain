package com.zp.model.zp;

/**
 * Created by topera on 09/07/17.
 */
public class Playlist {

    private Long id;
    private String title;
    private String image;
    private String imageBig;
    private String musicClientType;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMusicClientType() {
        return musicClientType;
    }

    public void setMusicClientType(String musicClientType) {
        this.musicClientType = musicClientType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageBig() {
        return imageBig;
    }

    public void setImageBig(String imageBig) {
        this.imageBig = imageBig;
    }
}
package com.zp.model.zp;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by rafael on 19/06/17.
 */
@XmlRootElement
public class Playlists {

    private List<Playlist> data;

    public Playlists(List<Playlist> data) {
        this.data = data;
    }

    public List<Playlist> getData() {
        return data;
    }

    public void setData(List<Playlist> data) {
        this.data = data;
    }

}
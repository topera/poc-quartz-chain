package com.topera.hello.model.deezer;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by topera on 09/07/17.
 */
@XmlRootElement
public class Playlists {

    private List<Playlist> data;
    private Integer total;

    public List<Playlist> getData() {
        return data;
    }

    public void setData(List<Playlist> data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
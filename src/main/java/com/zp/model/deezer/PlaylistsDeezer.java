package com.zp.model.deezer;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by rafael on 18/06/17.
 */
@XmlRootElement
public class PlaylistsDeezer {

    private List<PlaylistDeezer> data;
    private Integer total;

    public List<PlaylistDeezer> getData() {
        return data;
    }

    public void setData(List<PlaylistDeezer> data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
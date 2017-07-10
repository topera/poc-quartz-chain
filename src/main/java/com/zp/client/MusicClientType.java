package com.zp.client;

/**
 * Created by topera on 09/07/17.
 */
public enum MusicClientType {

    DEEZER,
    SPOTIFY;

    public static MusicClientType convertString(String musicClientType) {
        return MusicClientType.valueOf(musicClientType.toUpperCase());
    }

}

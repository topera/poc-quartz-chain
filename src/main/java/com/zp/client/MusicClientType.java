package com.zp.client;

/**
 * Possible types of music clients
 * Created by rafael on 18/06/17.
 */
public enum MusicClientType {

    DEEZER,
    SPOTIFY;

    public static MusicClientType convertString(String musicClientType) {
        return MusicClientType.valueOf(musicClientType.toUpperCase());
    }

}

package com.zp.client;

import com.zp.exceptions.ZPNotSupportedException;

/**
 * Created by topera on 09/07/17.
 */
public abstract class MusicClientFactory {

    public static MusicClient create(MusicClientType type){
        switch (type) {
            case DEEZER: return new DeezerClient();
            case SPOTIFY: return new SpotifyClient();
        }
        throw new ZPNotSupportedException();
    }

}

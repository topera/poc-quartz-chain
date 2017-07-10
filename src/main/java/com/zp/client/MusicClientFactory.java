package com.zp.client;

import com.zp.exceptions.ZPNotSupportedException;

/**
 * Factory to create the correct music client
 * Created by rafael on 18/06/17.
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

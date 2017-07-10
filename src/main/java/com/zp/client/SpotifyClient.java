package com.zp.client;

import com.zp.exceptions.ZPNotSupportedException;
import com.zp.model.zp.Playlist;
import com.zp.model.zp.Playlists;

/**
 * Client to access Spotify API (not implemented)
 * Created by rafael on 18/06/17.
 */
public class SpotifyClient extends MusicClient {

    @Override
    public Playlists getPlaylists() {
        throw new ZPNotSupportedException();
    }

    @Override
    public Playlist getPlaylist(Long id) {
        throw new ZPNotSupportedException();
    }

}

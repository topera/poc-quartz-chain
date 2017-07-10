package com.zp.client;

import com.zp.converters.DeezerConverter;
import com.zp.model.deezer.PlaylistDeezer;
import com.zp.model.deezer.PlaylistsDeezer;
import com.zp.model.zp.Playlist;
import com.zp.model.zp.Playlists;

/**
 * Created by topera on 09/07/17.
 */
public class DeezerClient extends MusicClient {

    private static final String BASE_URL = "http://api.deezer.com";
    private static final String URL_PLAYLISTS = "/chart/0/playlists";
    private static final String URL_PLAYLIST = "/playlist";

    @Override
    public Playlists getPlaylists() {
        String url = BASE_URL + URL_PLAYLISTS;
        PlaylistsDeezer playlistsDeezer = (PlaylistsDeezer) sendRequest(url, PlaylistsDeezer.class);
        return DeezerConverter.convertPlaylists(playlistsDeezer);
    }

    @Override
    public Playlist getPlaylist(Long id) {
        String url = BASE_URL + URL_PLAYLIST + "/" + id;
        PlaylistDeezer playlistDeezer = (PlaylistDeezer) sendRequest(url, PlaylistDeezer.class);
        return DeezerConverter.convertPlaylist(playlistDeezer);
    }

}

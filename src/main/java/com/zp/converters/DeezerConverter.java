package com.zp.converters;

import com.zp.client.MusicClientType;
import com.zp.model.deezer.PlaylistDeezer;
import com.zp.model.deezer.PlaylistsDeezer;
import com.zp.model.zp.Playlist;
import com.zp.model.zp.Playlists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by topera on 09/07/17.
 */
public abstract class DeezerConverter {

    private static final int MAX_PLAYLISTS = 7;

    /**
     * Converts Playlists from Deezer to our format
     * @param playlistsDeezer deezer format
     * @return zp format
     */
    public static Playlists convertPlaylists(PlaylistsDeezer playlistsDeezer){
        List<Playlist> data = new ArrayList<>();

        int maxPlaylists = MAX_PLAYLISTS;
        for (PlaylistDeezer playlistDeezer : playlistsDeezer.getData()) {
            if (data.size() < maxPlaylists) {
                data.add(convertPlaylist(playlistDeezer));
            }
        }

        return new Playlists(data);
    }

    /**
     * Converts one Playlist from Deezer to our format
     * @param playlistDeezer deezer format
     * @return zp format
     */
    public static Playlist convertPlaylist(PlaylistDeezer playlistDeezer){
        Playlist playlist = new Playlist();

        playlist.setId(playlistDeezer.getId());
        playlist.setMusicClientType(MusicClientType.DEEZER.toString().toLowerCase());
        playlist.setTitle(playlistDeezer.getTitle());
        playlist.setImage(playlistDeezer.getPicture());
        playlist.setDescription(playlistDeezer.getDescription());
        playlist.setImageBig(playlistDeezer.getPicture_medium());

        return playlist;
    }


}

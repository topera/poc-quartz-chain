package com.zp.api;

import com.zp.client.MusicClient;
import com.zp.client.MusicClientFactory;
import com.zp.client.MusicClientType;
import com.zp.model.zp.Playlist;
import com.zp.model.zp.Playlists;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by rafael on 18/06/17.
 */
@Produces({MediaType.APPLICATION_JSON})
@Path("playlist")
public class PlaylistResource {

    /**
     * List all playlists
     * @return playlists
     */
    @GET
    @Path("/{musicClientType}")
    public Playlists list(@PathParam("musicClientType") String musicClientType) {
        MusicClient musicClient = createMusicClient(musicClientType);
        return musicClient.getPlaylists();
    }

    /**
     * List details of a playlist
     * @return playlist
     */
    @GET
    @Path("/{musicClientType}/{id}")
    public Playlist list(@PathParam("musicClientType") String musicClientType, @PathParam("id") String id) {
        MusicClient musicClient = createMusicClient(musicClientType);
        return musicClient.getPlaylist(Long.valueOf(id));
    }

    private static MusicClient createMusicClient(String musicClientTypeParam) {
        MusicClientType musicClientType = MusicClientType.convertString(musicClientTypeParam);
        return MusicClientFactory.create(musicClientType);
    }

}
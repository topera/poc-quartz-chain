package com.zp.api;

import com.zp.client.DeezerClient;
import com.zp.model.zp.Playlists;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by topera on 09/07/17.
 */
@Produces({MediaType.APPLICATION_JSON})
@Path("/")
public class PlaylistResource {

    /**
     * List all playlists
     * @return playlists
     */
    @GET
    @Path("playlist")
    public Playlists list() {
        return new DeezerClient().getPlaylists();
    }

}
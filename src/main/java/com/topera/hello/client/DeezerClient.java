package com.topera.hello.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.topera.hello.model.deezer.Playlists;

/**
 * Created by topera on 09/07/17.
 */
public class DeezerClient {

    private static final String BASE_URL = "http://api.deezer.com";
    private static final String URL_PLAYLISTS = "/chart/0/playlists";

    public Playlists getPlaylists() {
        String url = BASE_URL + URL_PLAYLISTS;
        return (Playlists) sendRequest(url, Playlists.class);
    }

    private Object sendRequest(String url, Class expectedClass) {
        Client client = Client.create();
        WebResource webResource = client.resource(url);
        return getEntity(webResource, expectedClass);
    }

    private Object getEntity(WebResource webResource, Class expectedClass) {
        ClientResponse response = webResource.get(ClientResponse.class);
        return response.getEntity(expectedClass);
    }

}

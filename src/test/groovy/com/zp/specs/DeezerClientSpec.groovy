package com.zp.specs

import com.zp.client.DeezerClient
import com.zp.client.MusicClientFactory
import com.zp.client.MusicClientType
import spock.lang.Specification

/**
 * Created by rafael on 18/06/17.
 */
class DeezerClientSpec extends Specification {

    DeezerClient client

    void setup() {
        client = MusicClientFactory.create(MusicClientType.DEEZER) as DeezerClient
    }

    def "read playlists"() {
        when: "try to get playlists"
        def playlists = client.getPlaylists()

        then: "we get 10 playlists"
        playlists.getData().size() == 7
    }

}
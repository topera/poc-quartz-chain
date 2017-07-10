package com.zp.specs

import com.zp.client.DeezerClient
import com.zp.client.MusicClientFactory
import com.zp.client.MusicClientType
import com.zp.exceptions.ZPRequestError
import spock.lang.Specification

/**
 * Created by rafael on 18/06/17.
 */
class MusicClientSpec extends Specification {

    def "send request to wrong url returns error"() {
        when: "send request to wrong place"
        def client = MusicClientFactory.create(MusicClientType.DEEZER) as DeezerClient
        client.sendRequest("https://www.deezer.com/wrong-url", Object)

        then: "we get error"
        thrown ZPRequestError
    }

}
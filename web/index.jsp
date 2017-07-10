<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Zetta Playlist</title>
    <script src="js/lib/jquery-3.2.1.min.js"></script>
    <script src="js/lib/jquery.tmpl.min.js"></script>
    <script src="js/zp/Util.js"></script>
    <script src="js/zp/Controller.js"></script>

    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet" />

    <script id="playlists-template" type="text/x-jquery-tmpl">
        <ul>
        {{each(i, playlist) data}}
          <li data-id="{{html playlist.id}}" data-music-client-type="{{html playlist.musicClientType}}">
             <img src="{{html playlist.image}}"/>
             <p class="title normal">{{html playlist.title}}</p>
          </li>
        {{/each}}
        </ul>
    </script>

    <script id="details-template" type="text/x-jquery-tmpl">
        <img src="{{html imageBig}}"/>
        <p class="title normal">{{html title}}</p>
        <p class="description normal">{{html description}}</p>
    </script>

  </head>
  <body>
    <div id="header">
        <div class="left">
            <div id="zetta-logo"></div>
        </div>
        <div class="right">
            <em>Powered by</em>
            <div id="deezer-logo"></div>
        </div>
    </div>

    <div id="playlists-wrapper">
        <br/>
        <p class="normal">Top Brazilian Playlists:</p>
        <div id="playlists"></div>
    </div>

    <div id="details"></div>

  </body>
</html>

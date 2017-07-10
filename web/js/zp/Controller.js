/**
 * class Controller
 */
function Controller(){

    /**
     * Bind events
     */
    this.addEvents = function () {
        UTIL.log("Adding events");

        $(document).on("click", "#playlists ul li", function(obj){
            var id = $(this).data("id");
            var musicClientType = $(this).data("music-client-type");
            CONTROLLER.loadDetails(id, musicClientType);
        });

    };

    /**
     * Load playlists and update screen
     * @param musicClientType
     */
    this.loadPlaylists = function (musicClientType) {
        UTIL.log("Loading playlists from " + musicClientType);
        var url = "/api/playlist/" + musicClientType;

        $.getJSON(url, function (data) {
            $("#playlists").html($("#playlists-template").tmpl(data));
            UTIL.log("Template Updated");
        });
    };

    /**
     * Load details of a playlist
     * @param id of playlist
     */
    this.loadDetails = function(id, musicClientType) {
        UTIL.log("Loading details of playlist " + id);
        var url = "/api/playlist/" + musicClientType + "/" + id;

        $.getJSON(url, function(data) {
            $("#details").html($("#details-template").tmpl(data));
            UTIL.log("Template Updated");
        });
    }

}

// create globals
window.CONTROLLER = new Controller();
window.UTIL = new Util();

// start
CONTROLLER.addEvents();
CONTROLLER.loadPlaylists('deezer');

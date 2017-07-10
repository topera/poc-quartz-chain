/**
 * class Util
 */
function Util(){

    this.log = function(message, addPrefix) {
        if (addPrefix) {
            console.log("[ZP] " + message);
        } else {
            console.log(message);
        }
    }

}
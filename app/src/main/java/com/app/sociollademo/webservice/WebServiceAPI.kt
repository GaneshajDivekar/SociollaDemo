package logi.retail.core.network.webservice

class WebServiceAPI {

    companion object {
        const val SERVERBASE_URL = "https://api.flickr.com/services/rest/"
        const val verticalItemsApi =
            "?method=flickr.photos.search&api_key=3e7cc266ae2b0e0d78e279ce8e361736&format=json&nojsoncallback=1&text=nature"
        const val horizontalItemsApi =
            "?method=flickr.photos.search&api_key=3e7cc266ae2b0e0d78e279ce8e361736&format=json&nojsoncallback=1&text=nature"


    }


}
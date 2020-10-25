package logi.retail.core.network.webservice


import com.app.sociollademo.model.api.horizontalmodel.HorizontalExample
import com.app.sociollademo.model.api.verticalmodel.Example
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPIinterface {

    // @FormUrlEncoded
    @GET(WebServiceAPI.verticalItemsApi)
    abstract fun getAllVerticalApiResponse(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): Observable<Example>


    @GET(WebServiceAPI.horizontalItemsApi)
    abstract fun getAllHorizontalApiResponse(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): Observable<HorizontalExample>
}

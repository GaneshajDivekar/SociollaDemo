package logi.retail.core.network.webservice


import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitCallAPI {

    companion object {

        private var retrofitAPIinterfaceRx: RetrofitAPIinterface? = null
        private var retrofitAPIinterface: RetrofitAPIinterface? = null


        internal var okHttpClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        fun getInstanceRx(baseUrl: String): RetrofitAPIinterface? {
            if (retrofitAPIinterfaceRx == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build()

                retrofitAPIinterfaceRx = retrofit.create(RetrofitAPIinterface::class.java)
            }

            return retrofitAPIinterfaceRx
        }


    }

}




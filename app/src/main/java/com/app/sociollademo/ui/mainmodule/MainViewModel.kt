package com.app.sociollademo.ui.mainmodule

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.sociollademo.base.BaseViewModel
import com.app.sociollademo.model.api.horizontalmodel.HorizontalExample
import com.app.sociollademo.model.api.horizontalmodel.HorizontalPhoto
import com.app.sociollademo.model.api.verticalmodel.Example
import com.app.sociollademo.model.api.verticalmodel.Photo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import logi.retail.core.network.webservice.RetrofitCallAPI
import logi.retail.core.network.webservice.WebServiceAPI

class MainViewModel(application: Application) : BaseViewModel(application) {
    var mainNavigator: MainNavigator? = null
    fun callVerticalApi(searchText: Int, aapid: Int): LiveData<Example> {
        val loginModel = MutableLiveData<Example>()
        RetrofitCallAPI.getInstanceRx(WebServiceAPI.SERVERBASE_URL)!!
            .getAllVerticalApiResponse(searchText, aapid)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Example>() {
                override fun onComplete() {

                }

                override fun onNext(t: Example) {

                    loginModel.value =t
                }

                override fun onError(e: Throwable) {
                    Log.e("onError", "" + e.message)
                    mainNavigator?.onError()
                }
            })
        return loginModel

    }


    fun callhorizontal(searchText: Int, aapid: Int): LiveData<List<HorizontalPhoto>> {
        val loginModel = MutableLiveData<List<HorizontalPhoto>>()
        RetrofitCallAPI.getInstanceRx(WebServiceAPI.SERVERBASE_URL)!!
            .getAllHorizontalApiResponse(searchText, aapid)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<HorizontalExample>() {
                override fun onComplete() {

                }

                override fun onNext(t: HorizontalExample) {

                    loginModel.value = t.photos?.photo!!
                }

                override fun onError(e: Throwable) {
                    Log.e("onError", "" + e.message)
                    mainNavigator?.onError()
                }
            })
        return loginModel

    }




}
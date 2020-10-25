package com.app.sociollademo.ui.mainmodule

import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.sociollademo.R
import com.app.sociollademo.base.BaseActivity
import com.app.sociollademo.databinding.ActivityMainBinding
import com.app.sociollademo.model.api.verticalmodel.Photo
import com.app.sociollademo.paging.PaginationListener
import com.app.sociollademo.ui.mainmodule.adapter.VerticalAdapter
import com.app.sociollademo.utils.DialogUtils
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {

    var activityMainBinding: ActivityMainBinding? = null
    val mainViewModel: MainViewModel by viewModel()
    var allDataList = ArrayList<String>()
    private var mAdapter: VerticalAdapter? = null
    lateinit var layoutmanager: LinearLayoutManager
    private var isLoading = false
    private var isLastPag = false
    private var totalPage: Int = 0
    var page = 0
    var per_page = 300


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = getViewDataBinding()
        activityMainBinding?.viewModel = this
        mainViewModel.mainNavigator = this

        initView()


    }

    private fun initView() {

        callVerticalApi(page, per_page)


    }

    private fun callHorizontalApi(
        page1: List<Photo>,
        page: Int,
        perPage: Int
    ) {

        mainViewModel.callhorizontal(page, perPage).observe(this, androidx.lifecycle.Observer {
            if (it != null) {

                DialogUtils.stopProgressDialog()
                mAdapter = VerticalAdapter(page1, this@MainActivity, it)
                val mLayoutManager: RecyclerView.LayoutManager =
                    LinearLayoutManager(
                        this@MainActivity,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                activityMainBinding!!.recyclerview.setLayoutManager(mLayoutManager)
                activityMainBinding!!.recyclerview.setItemAnimator(DefaultItemAnimator())
                activityMainBinding!!.recyclerview.setAdapter(mAdapter)

            } else {
                DialogUtils.stopProgressDialog()

            }


        })


    }

    private fun callVerticalApi(
        page1: Int,
        per_page1: Int
    ) {
        DialogUtils.startProgressDialog(this@MainActivity)
        mainViewModel.callVerticalApi(page1, per_page1).observe(this, androidx.lifecycle.Observer {
            if (it != null) {


                totalPage = it.photos!!.total!!.toInt()

                page = it.photos!!.page?.toInt()!!
                per_page = it.photos!!.perpage?.toInt()!!




                callHorizontalApi(it.photos!!.photo!!, page, per_page)


            } else {
                DialogUtils.stopProgressDialog()

            }


        })
    }


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): MainViewModel {
        return mainViewModel
    }

    override fun setUp(savedInstanceState: Bundle?) {


    }

    override fun onError() {

    }


}
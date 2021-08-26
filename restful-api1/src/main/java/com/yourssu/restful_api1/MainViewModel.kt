package com.yourssu.restful_api1

import android.util.Log
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel: ViewModel() {

    val itemList: ListLiveData<CentersData> by lazy {
        ListLiveData<CentersData>().also {
            getData(RetrofitAPI.createRetrofitApi())
        }
    }
    private val centerData = ArrayList<CentersData>()
    private val rvAdapter = MainRvAdapter(centersList = centerData)
    var disposable: Disposable? = null
    private var page = 1
    private val perPage = 30

    fun increaseData() {
        page++
        getData(RetrofitAPI.createRetrofitApi())
        rvAdapter.notifyItemRangeInserted((page - 1) * 30, 30)
    }

    private fun getData(retrofitAPI: RetrofitAPI) {
        disposable = retrofitAPI.getCenters(page, perPage, RetrofitAPI.serviceKey)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    itemList.addAll(it.data)
                    rvAdapter.centersList = centerData
                    rvAdapter.notifyDataSetChanged()
                    Log.d(this::class.simpleName, "onNext")
                }, {
                    Log.d(this::class.simpleName, "onError")
                }, {
                    Log.d(this::class.simpleName, "onComplete")
                })
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}
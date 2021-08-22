package com.yourssu.restful_api1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.yourssu.restful_api1.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val centerData = ArrayList<CentersData>()
    private val rvAdapter = MainRvAdapter(centersList = centerData)
    private var page = 1
    private val perPage = 30
    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recyclerviewRestful.adapter = rvAdapter
        getData(RetrofitAPI.createRetrofitApi())

        binding.recyclerviewRestful.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!binding.recyclerviewRestful.canScrollVertically(1)){

                    if (newState == 0) {
                        page++
                        getData(RetrofitAPI.createRetrofitApi())
                        rvAdapter.notifyItemRangeInserted((page - 1) * 30, 30)
                    }
                }
            }
        })
    }

    private fun getData(retrofitAPI: RetrofitAPI) {
        disposable = retrofitAPI.getCenters(page, perPage, RetrofitAPI.serviceKey)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                centerData.addAll(it.data)
                rvAdapter.centersList = centerData
                rvAdapter.notifyDataSetChanged()
                Log.d(this::class.simpleName, "onNext")
            }, {
                Log.d(this::class.simpleName, "onError")
            }, {
                Log.d(this::class.simpleName, "onComplete")
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.let { disposable!!.dispose() }
    }
}
package com.yourssu.restful_api1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.yourssu.restful_api1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val centerData = ArrayList<CentersData>()
    private val rvAdapter = MainRvAdapter(centersList = centerData)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.recyclerviewRestful.adapter = rvAdapter
        viewModel.itemList.observe(this, Observer {
            rvAdapter.centersList = it as ArrayList<CentersData>
            rvAdapter.notifyDataSetChanged()
        })

        binding.recyclerviewRestful.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!binding.recyclerviewRestful.canScrollVertically(1)){

                    if (newState == 0) {
                        viewModel.increaseData()
                    }
                }
            }
        })
    }
}
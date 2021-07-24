package com.yourssu.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var allUmuList = arrayListOf<UmuData>( //데이터 목록을 가지고 있는, arrayList를 반환하는 arrayListOf
            UmuData(umuPhotoId = R.drawable.image1, title = "Juju_umu1"),
            UmuData(umuPhotoId = R.drawable.image2, title = "Juju_umu2"),
            UmuData(umuPhotoId = R.drawable.image3, title = "Juju_umu3"),
            UmuData(umuPhotoId = R.drawable.image4, title = "Juju_umu4"),
            UmuData(umuPhotoId = R.drawable.image5, title = "Juju_umu5"),
            UmuData(umuPhotoId = R.drawable.image6, title = "Juju_umu6"),
            UmuData(umuPhotoId = R.drawable.image7, title = "Juju_umu7"),
            UmuData(umuPhotoId = R.drawable.image8, title = "Juju_umu8"),
            UmuData(umuPhotoId = R.drawable.image9, title = "Juju_umu9"),
            UmuData(umuPhotoId = R.drawable.image10, title = "Juju_umu10")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        allUmuList.shuffle()

        val rvAdapter = MainRvAdapter(this, allUmuList)
        recyclerview_assign3.adapter = rvAdapter

        //LinearLayoutManager, GridLayoutManager, StaggeredGridLayoutManager
        //LayoutManager의 역할 = RecyclerView의 각 item들을 배치, item이 보이지 않을 경우 재사용 여부 결정(타이밍을 알려줌)
        //item 재사용 시 LayoutManager는 Adapter에게 view의 요소를 다른 데이터로 대체할지 물어봄
        val layout = LinearLayoutManager(this)
        recyclerview_assign3.layoutManager = layout

        recyclerview_assign3.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!recyclerview_assign3.canScrollVertically(1)){
                    if (newState == 0) {
                        Log.d(this::class.simpleName, "new")
                        rvAdapter.umuList.shuffle()
                        rvAdapter.notifyDataSetChanged()
                    }
                }
            }
        })
    }
}
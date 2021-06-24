package com.yourssu.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card.*

class MainActivity : AppCompatActivity() {

    var allUmuList = arrayListOf<UmuData>( //데이터 목록을 가지고 있는, arrayList를 반환하는 arrayListOf
            UmuData(photo = R.drawable.image1, title = "Juju_umu1"),
            UmuData(photo = R.drawable.image2, title = "Juju_umu2"),
            UmuData(photo = R.drawable.image3, title = "Juju_umu3"),
            UmuData(photo = R.drawable.image4, title = "Juju_umu4"),
            UmuData(photo = R.drawable.image5, title = "Juju_umu5"),
            UmuData(photo = R.drawable.image6, title = "Juju_umu6"),
            UmuData(photo = R.drawable.image7, title = "Juju_umu7"),
            UmuData(photo = R.drawable.image8, title = "Juju_umu8"),
            UmuData(photo = R.drawable.image9, title = "Juju_umu9"),
            UmuData(photo = R.drawable.image10, title = "Juju_umu10")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview_assign3.adapter = MainRvAdapter(this, allUmuList)
        //val rvAdapter = MainRvAdapter(this, allUmuList)
        //recyclerview_assign3.adapter = rvAdapter

        //LinearLayoutManager, GridLayoutManager, StaggeredGridLayoutManager
        //LayoutManager의 역할 = RecyclerView의 각 item들을 배치, item이 보이지 않을 경우 재사용 여부 결정
        //item 재사용 시 LayoutManager는 Adapter에게 view의 요소를 다른 데이터로 대체할지 물어봄
        recyclerview_assign3.layoutManager = LinearLayoutManager(this)
        //var layout = LinearLayoutManager(this)
        //recyclerview_assign3.layoutManager = layout
        recyclerview_assign3.adapter = MainRvAdapter(this, allUmuList)
    }
}
    // 이미지를 길게 누를 시 -> 롱클릭 이벤트 (setOnLongClickListener)
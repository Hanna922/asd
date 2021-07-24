package com.yourssu.assignment3

import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

//context 쉽게 말하자면...? : 어플리케이션이나 객체의 현재 상태
class MainRvAdapter(val context: MainActivity, val umuList: ArrayList<UmuData>) :
        RecyclerView.Adapter<MainRvAdapter.Holder>() {

    //inner class를 사용함으로써 참조를 가능하게 함
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnLongClickListener {
        init {
            itemView.setOnLongClickListener(this)
        }
        val umuImageView = itemView.findViewById<ImageView>(R.id.umuImage)
        val umuTextView = itemView.findViewById<TextView>(R.id.umuText)

        //ViewHolder와 클래스의 각 변수를 연동하는 역할
        //getResources().getIdentifier(파일명, 디렉토리명, 패키지명)
        //-> 문자열로 해당 Resource 또는 레이아웃에 포함된 View의 Id 값을 가져옴
        fun bind (umuData: UmuData, context: Context) {
            Log.d(this::class.simpleName, "bind")

            //val resourceId = context.resources.getIdentifier(umuData.photo.toString(), "drawable", context.packageName)
            //umuImageView.setImageResource(resourceId)
            umuImageView.setImageResource(umuData.umuPhotoId)
            umuTextView.text = umuData.title
        }

        override fun onLongClick(view: View): Boolean {
            val builder = AlertDialog.Builder(context)
            builder.setMessage(umuTextView.text).show()
            return true
        }
    }

    //화면을 최초 로딩하여 만들어진 View가 없는 경우 xml 파일을 inflate하여 ViewHolder를 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.card, parent, false)
        Log.d(this::class.simpleName, "onCreateViewHolder ${Holder(view)}")
        return Holder(view)
    }

    //RecyclerView로 만들어지는 item의 총 개수를 반환
    override fun getItemCount(): Int {
        Log.d(this::class.simpleName, "getItemCount ${umuList.size}")
        return umuList.size
    }

    //onCreateViewHolder에서 만든 view와 실제 입력되는 각각의 데이터를 연결
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(umuList[position], context)
        Log.d(this::class.simpleName, "onBindViewHolder $position")
    }
}

//getItemCount -> onCreateViewHolder에서 공간 설정 -> Holder -> onBindViewHolder에서 umulist 담음
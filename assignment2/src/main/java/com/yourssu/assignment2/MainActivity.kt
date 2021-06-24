package com.yourssu.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var oper=true
    var dot=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View)
    {
        if(oper) {result.text = ""} //setText("") 텍스트 변경, 코틀린에선 text
        oper=false // Q. 필요없는 구문인가
        val select= view as Button //view -> Button 형태 변경 (말 그대로 버튼을 select에 대입)
        var click:String=result.text.toString() // result 값을 얻는 과정 (click에 대입)
        when(select) //(select.id) 값에 따른 when / Q. .id를 제외한다면 ? -> 정상 작동함
        {
            zero -> click += "0"
            one-> click += "1"
            two-> click += "2"
            three-> click += "3"
            four-> click += "4"
            five-> click += "5"
            six-> click += "6"
            seven-> click += "7"
            eight-> click += "8"
            nine-> click += "9"
            point->
            {
                if(!dot) {click += "."} //if(dot==false){click+="."} -> if(!dot){click+="."}, .은 두 번 이상 찍힐 수 없음
                dot=true
            }
            plus_minus-> click= "-$click" //"-"+click
        }
        result.text = click
    }

    var op="+"
    var firstNumber=""

    fun operatorEvent(view: View)
    {
        when(view as Button) //val select = view as Button을 선언하고 when(select) 과 동일
        {
            plus-> op="+"
            minus-> op="-"
            multiplication-> op="X"
            division-> op="/"
        }
        firstNumber=result.text.toString()
        oper=true
        dot=false
    }

    fun equalsEvent(view: View) //(view: View) -> parameter view를 사용안함 But 생략 시 xml onclick에 오류 발생
    {
        val newNumber=result.text.toString()
        var finalNumber:Double?=null
        when(op)
        {
            "+"-> finalNumber=firstNumber.toDouble() + newNumber.toDouble()
            "-"-> finalNumber=firstNumber.toDouble() - newNumber.toDouble()
            "X"-> finalNumber=firstNumber.toDouble() * newNumber.toDouble()
            "/"-> finalNumber=firstNumber.toDouble() / newNumber.toDouble()
        }
        result.text = finalNumber.toString()
        oper=true
    }

    fun percentEvent(view: View)
    {
        val number=(result.text.toString().toDouble())/100
        result.text = number.toString()
        oper=true
    }

    fun cancelEvent(view: View)
    {
        result.text = ""
        oper=true
        dot=false
    }
}
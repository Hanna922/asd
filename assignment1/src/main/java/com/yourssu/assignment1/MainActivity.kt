package com.yourssu.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*

//공식 문서 https://developer.android.com/guide/topics/ui/controls/checkbox?hl=ko#kotlin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkBox1.setOnCheckedChangeListener(CheckboxListener())
        checkBox2.setOnCheckedChangeListener(CheckboxListener())
        checkBox3.setOnCheckedChangeListener(CheckboxListener())
        checkBox4.setOnCheckedChangeListener(CheckboxListener())

        radioButton.setOnClickListener{
            checkBox1.isChecked = false
            checkBox2.isChecked = false
            checkBox3.isChecked = false
            checkBox4.isChecked = false
        }
        radioButton2.setOnClickListener{
            checkBox1.isChecked = true
            checkBox2.isChecked = true
            checkBox3.isChecked = true
            checkBox4.isChecked = true
        }
    }

    inner class CheckboxListener: CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            when (buttonView?.id){
                R.id.checkBox1 -> {
                    if (isChecked) text.append("checkbox1 활성")
                    else text.append("checkbox1 해제")
                }
                R.id.checkBox2 -> {
                    if (isChecked) text.append("checkbox2 활성")
                    else text.append("checkbox2 해제")
                }
                R.id.checkBox3 -> {
                    if (isChecked) text.append("checkbox3 활성")
                    else text.append("checkbox3 해제")
                }
                R.id.checkBox4 -> {
                    if (isChecked) text.append("checkbox4 활성")
                    else text.append("checkbox4 해제")
                }
            }
        }
    }
}
package com.yourssu.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

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

        //android kotlin data save(?) : https://minwook-shin.github.io/android-kotlin-sharedpreferences/
        val preference = this.getPreferences(0)
        val editor = preference.edit()

        record.setOnClickListener {
            editor.putBoolean("radioButton", radioGroup.radioButton.isChecked).apply()
            editor.putBoolean("radioButton2", radioGroup.radioButton2.isChecked).apply()
            editor.putBoolean("radioButton3", radioGroup.radioButton3.isChecked).apply()
            editor.putBoolean("checkBox1", checkBox1.isChecked).apply()
            editor.putBoolean("checkBox2", checkBox2.isChecked).apply()
            editor.putBoolean("checkBox3", checkBox3.isChecked).apply()
            editor.putBoolean("checkBox4", checkBox4.isChecked).apply()
        }

        rewind.setOnClickListener {
            radioGroup.radioButton.isChecked = preference.getBoolean("radioButton", radioGroup.radioButton.isChecked)
            radioGroup.radioButton2.isChecked = preference.getBoolean("radioButton2", radioGroup.radioButton2.isChecked)
            radioGroup.radioButton3.isChecked = preference.getBoolean("radioButton3", radioGroup.radioButton3.isChecked)
            checkBox1.isChecked = preference.getBoolean("checkBox1", checkBox1.isChecked)
            checkBox2.isChecked = preference.getBoolean("checkBox2", checkBox2.isChecked)
            checkBox3.isChecked = preference.getBoolean("checkBox3", checkBox3.isChecked)
            checkBox4.isChecked = preference.getBoolean("checkBox4", checkBox4.isChecked)
        }
    }

    inner class CheckboxListener: CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            if (checkBox1.isChecked || checkBox2.isChecked || checkBox3.isChecked || checkBox4.isChecked) {
                when (buttonView?.id){
                    R.id.checkBox1 -> {
                        if (isChecked) {
                            text.append("checkbox1 활성")
                            radioGroup.radioButton3.isChecked = true
                        }
                        else {
                            text.append("checkbox1 해제")
                            radioGroup.radioButton3.isChecked = true
                        }
                    }
                    R.id.checkBox2 -> {
                        if (isChecked) {
                            text.append("checkbox2 활성")
                            radioGroup.radioButton3.isChecked = true
                        }
                        else {
                            text.append("checkbox2 해제")
                            radioGroup.radioButton3.isChecked = true
                        }
                    }
                    R.id.checkBox3 -> {
                        if (isChecked) {
                            text.append("checkbox3 활성")
                            radioGroup.radioButton3.isChecked = true
                        }
                        else {
                            text.append("checkbox3 해제")
                            radioGroup.radioButton3.isChecked = true
                        }
                    }
                    R.id.checkBox4 -> {
                        if (isChecked) {
                            text.append("checkbox4 활성")
                            radioGroup.radioButton3.isChecked = true
                        }
                        else {
                            text.append("checkbox4 해제")
                            radioGroup.radioButton3.isChecked = true
                        }
                    }
                }
                if (checkBox1.isChecked && checkBox2.isChecked && checkBox3.isChecked && checkBox4.isChecked) {
                    radioGroup.radioButton2.isChecked = true
                }
            }
            else {
                radioGroup.radioButton.isChecked = true
            } //알고리즘 (?) 생각하고 코드 작성하기
        }
    }
}
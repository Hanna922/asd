package com.yourssu.assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_name.*

class MainActivity : AppCompatActivity() {

    private val nameFragment = NameFragment()
    private val birthdayFragment = BirthdayFragment()
    private val schoolFragment = SchoolFragment()
    private val allFragment = AllFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationBar() {
        }
    }

    private fun navigationBar(function: () -> Unit) {
        bottom_navi.run {
            setOnNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.name -> {
                        replaceFragment(nameFragment)
                    }
                    R.id.birthday -> {
                        replaceFragment(birthdayFragment)
                    }
                    R.id.school -> {
                        replaceFragment(schoolFragment)
                    }
                    R.id.all -> {
                        replaceFragment(allFragment)
                    }
                }
                true
            }
            selectedItemId = R.id.name
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout, fragment)
        fragmentTransaction.commit()
    }
}
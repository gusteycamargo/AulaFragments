package com.camargo.aulafrag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.camargo.aulafrag.fragments.BookFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val bookFragment = BookFragment()
//
//        useFragment(bookFragment)
    }

//    private fun useFragment(fragment: Fragment) {
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.fragment, fragment)
//            commit()
//        }
//    }
}
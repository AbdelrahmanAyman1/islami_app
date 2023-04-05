package com.abdo.islami.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.abdo.islami.R
import com.abdo.islami.fragments.HadethFragment
import com.abdo.islami.fragments.QuranFragment
import com.abdo.islami.fragments.RadioFragment
import com.abdo.islami.fragments.SebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigation: BottomNavigationView
    lateinit var switchMaterial: SwitchMaterial

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigation = findViewById(R.id.bottom_navigation)
        switchMaterial = findViewById(R.id.switch_mode)
        bottomNavigation.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_quran -> {
                    pushFragment(QuranFragment())
                }
                R.id.navigation_hadeth -> {
                    pushFragment(HadethFragment())
                }
                R.id.navigation_sebha -> {
                    pushFragment(SebhaFragment())
                }
                R.id.navigation_radio -> {
                    pushFragment(RadioFragment())
                }
            }

            return@OnItemSelectedListener true
        })
        bottomNavigation.selectedItemId = R.id.navigation_quran
        switchMaterial.setOnClickListener {
            if (switchMaterial.isChecked == false) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
    }


    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment).commit()
    }
}
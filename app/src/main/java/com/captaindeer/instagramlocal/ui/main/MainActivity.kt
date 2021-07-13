package com.captaindeer.instagramlocal.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.captaindeer.instagramlocal.R
import com.captaindeer.instagramlocal.ui.home.HomeFragment
import com.captaindeer.instagramlocal.ui.login.LoginActivity
import com.captaindeer.instagramlocal.utils.MySharedPreferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var homeFragment: HomeFragment? = null
 //   private var searchFragment: SearchFragment? = null
 //   private var profileFragment: ProfileFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeFragment = HomeFragment()
   //     searchFragment = SearchFragment()
   //     profileFragment = ProfileFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_main, homeFragment!!)
            addToBackStack(null)
            commit()
        }


        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fl_main, homeFragment!!)
                        addToBackStack(null)
                        commit()
                    }
                }
                R.id.search -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fl_main, homeFragment!!)
                        addToBackStack(null)
                        commit()
                    }
                }
                R.id.logout -> {
                    MySharedPreferences.closeSession(this,false)
                    finish()
                    var intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
                R.id.profile -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fl_main, homeFragment!!)
                        addToBackStack(null)
                        commit()
                    }
                }
            }
            true
        }

    }
}
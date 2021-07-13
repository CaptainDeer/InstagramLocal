package com.captaindeer.instagramlocal.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.captaindeer.instagramlocal.R
import com.captaindeer.instagramlocal.ui.main.MainActivity
import com.captaindeer.instagramlocal.ui.registry.RegistryActivity
import com.captaindeer.instagramlocal.utils.MySharedPreferences
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginInterface.View, View.OnClickListener {

    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this, this)
        presenter.getSession()

        btn_login.setOnClickListener(this)
        tvRegistry.setOnClickListener(this)

    }

    override fun onResume() {
        super.onResume()
        presenter.getSession()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_login -> {
                if (presenter.verifyLogin()) {
                    finish()
                    MySharedPreferences.setUserData(this, "email", etEmail.text.toString())
                    goToHomeScreen()
                } else
                    Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show()
            }
            R.id.tvRegistry -> {
                var intent = Intent(this, RegistryActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun goToHomeScreen() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
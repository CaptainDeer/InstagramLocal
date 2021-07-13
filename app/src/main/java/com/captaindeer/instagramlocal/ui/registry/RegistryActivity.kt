package com.captaindeer.instagramlocal.ui.registry

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.captaindeer.instagramlocal.R
import com.captaindeer.instagramlocal.data.local.entities.UserEntity
import com.captaindeer.instagramlocal.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_registry.*

class RegistryActivity : AppCompatActivity(), RegistryInterface.View, View.OnClickListener {

    private var presenter: RegistryPresenter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registry)

        presenter = RegistryPresenter(this)

        registry_btnRegistry.setOnClickListener(this)
    }

    override fun getUser(): UserEntity {
        val name = registry_etName.text.toString()
        val email = registry_etEmail.text.toString()
        val password = registry_etPassword.text.toString()
        return UserEntity(name,email,password)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.registry_btnRegistry -> {
                if (registry_etEmail.text!!.isEmpty() || registry_etPassword.text!!.isEmpty() || registry_etName.text!!.isEmpty()) {
                    Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
                } else {
                    presenter!!.saveUser(getUser())
                    finish()
                    var intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Login with your new account", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
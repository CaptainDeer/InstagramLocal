package com.captaindeer.instagramlocal.ui.login

import android.content.Context
import com.captaindeer.instagramlocal.data.local.InstagramDatabase
import com.captaindeer.instagramlocal.utils.MySharedPreferences
import kotlinx.android.synthetic.main.activity_login.*

class LoginPresenter(private val context: Context, private val view: LoginActivity) :
    LoginInterface.Presenter {

    private val database = InstagramDatabase(context)

    override fun verifyLogin(): Boolean {
        var user = database.userDao()
            .validUser(view.etEmail.text.toString(), view.etPassword.text.toString())
        return user != null
    }

    override fun getSession() {
        val session = MySharedPreferences.getUserData(context, "email")
        if (session != "")
            view.goToHomeScreen()
    }

}
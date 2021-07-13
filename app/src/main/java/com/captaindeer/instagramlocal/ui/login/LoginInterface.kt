package com.captaindeer.instagramlocal.ui.login

interface LoginInterface {
    interface View{
        fun goToHomeScreen()
    }
    interface Presenter{
        fun verifyLogin():Boolean
        fun getSession()
    }
}
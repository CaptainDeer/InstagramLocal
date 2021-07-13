package com.captaindeer.instagramlocal.ui.registry

import android.content.Context
import com.captaindeer.instagramlocal.data.local.InstagramDatabase
import com.captaindeer.instagramlocal.data.local.entities.UserEntity

class RegistryPresenter(private val context: Context) : RegistryInterface.Presenter {

    private var database = InstagramDatabase(context)

    override fun saveUser(userEntity: UserEntity) {
        database.userDao().insert(userEntity)
    }


}
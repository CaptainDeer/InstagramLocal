package com.captaindeer.instagramlocal.ui.registry

import com.captaindeer.instagramlocal.data.local.entities.UserEntity

interface RegistryInterface {
    interface View{
        fun getUser():UserEntity
    }
    interface Presenter{
        fun saveUser(userEntity: UserEntity)
    }
}
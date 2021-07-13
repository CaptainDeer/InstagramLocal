package com.captaindeer.instagramlocal.ui.newPost

import android.content.Context
import android.net.Uri
import com.captaindeer.instagramlocal.data.local.InstagramDatabase
import com.captaindeer.instagramlocal.data.local.entities.PostEntity

class NewPostPresenter(private val context: Context): NewPostInterface.Presenter {

    private val database = InstagramDatabase(context)

    override fun createNewPost(postEntity: PostEntity, file: Uri) {
        database.postDao().insert(postEntity)
    }

}
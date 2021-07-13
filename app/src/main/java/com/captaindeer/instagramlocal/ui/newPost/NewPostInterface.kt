package com.captaindeer.instagramlocal.ui.newPost

import android.net.Uri
import com.captaindeer.instagramlocal.data.local.entities.PostEntity

interface NewPostInterface {
    interface View {
        fun getPost():PostEntity
    }
    interface Presenter {
        fun createNewPost(postEntity: PostEntity, file: Uri)
    }
}
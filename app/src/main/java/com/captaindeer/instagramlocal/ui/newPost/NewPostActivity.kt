package com.captaindeer.instagramlocal.ui.newPost

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import com.captaindeer.instagramlocal.R
import com.captaindeer.instagramlocal.data.local.entities.PostEntity
import kotlinx.android.synthetic.main.activity_new_post.*
import java.io.IOException

class NewPostActivity : AppCompatActivity(), NewPostInterface.View, View.OnClickListener {

    private var filePath: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post)

        img_newProduct.setOnClickListener(this)
        btn_post.setOnClickListener(this)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 22 && resultCode == RESULT_OK && data != null) {
            filePath = data.data

            try {
                val bitMap: Bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                img_newProduct.setImageBitmap(bitMap)
            } catch (e: IOException) {
                Log.e("TAG", e.printStackTrace().toString())
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.img_newProduct -> {
                chooseImage()
            }
            R.id.btn_post -> {

            }
        }
    }

    private fun chooseImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_PICK
        startActivityForResult(
            Intent.createChooser(intent, "Select Picture"),
            22
        )
    }

    override fun getPost(): PostEntity {
        val img =
    }
}
package com.captaindeer.instagramlocal.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.captaindeer.instagramlocal.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeInterface.View, View.OnClickListener {

    private var homePresenter: HomePresenter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homePresenter = HomePresenter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_new_post.setOnClickListener(this)
        btn_new_post.show()


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_new_post -> {
                Toast.makeText(requireContext(),"Si jalo", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
package com.saifi369.dynamicbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.saifi369.dynamicbinding.adapter.PersonAdapter
import com.saifi369.dynamicbinding.databinding.ActivityMainBinding
import com.saifi369.dynamicbinding.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dataList = User.userList

        //val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        //binding.userList = dataList

        //val binding: ViewDataBinding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        //binding.setVariable(BR.userList, dataList)

        //val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //binding.userList = dataList

        val binding: ViewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setVariable(BR.userList, dataList)

    }
}
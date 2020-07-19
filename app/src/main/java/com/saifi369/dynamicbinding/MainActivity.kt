package com.saifi369.dynamicbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.saifi369.dynamicbinding.adapter.PersonAdapter
import com.saifi369.dynamicbinding.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_logs.layoutManager = LinearLayoutManager(this)
        rv_logs.adapter = PersonAdapter(User.userList)
    }
}
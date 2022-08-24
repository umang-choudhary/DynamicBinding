package com.saifi369.dynamicbinding.bindingadapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saifi369.dynamicbinding.adapter.PersonAdapter
import com.saifi369.dynamicbinding.model.User

@BindingAdapter("bindList")
fun bindRecyclerViewList(view: RecyclerView, dataList: List<User>) {

    if (dataList.isEmpty())
        return

    val layoutManager = view.layoutManager
    if (layoutManager == null)
        view.layoutManager = LinearLayoutManager(view.context)

    var adapter = view.adapter

    if (adapter == null) {
        adapter = PersonAdapter(dataList)
        view.adapter = adapter
    }

}
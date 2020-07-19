package com.saifi369.dynamicbinding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.saifi369.dynamicbinding.databinding.ItemCallBinding
import com.saifi369.dynamicbinding.databinding.ItemEmailBinding
import com.saifi369.dynamicbinding.databinding.ItemMessageBinding
import com.saifi369.dynamicbinding.model.User

private const val TYPE_CALL = 0
private const val TYPE_EMAIL = 1
private const val TYPE_MESSAGE = 2

class PersonAdapter(private val userList: List<User>) :
    RecyclerView.Adapter<PersonAdapter.BindingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = when (viewType) {
            TYPE_CALL -> {
                ItemCallBinding.inflate(layoutInflater, parent, false)
            }
            TYPE_EMAIL -> {
                ItemEmailBinding.inflate(layoutInflater, parent, false)
            }
            TYPE_MESSAGE -> {
                ItemMessageBinding.inflate(layoutInflater, parent, false)
            }
            else -> throw IllegalArgumentException("Unknown view type")
        }

        return BindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val user = userList.get(position)
        holder.itemview.setVariable(BR.user,user)
        holder.itemview.executePendingBindings()
    }

    override fun getItemCount() = userList.size

    override fun getItemViewType(position: Int): Int {
        return userList.get(position).logType.ordinal
    }

    class BindingViewHolder(val itemview: ViewDataBinding) : RecyclerView.ViewHolder(itemview.root)

}
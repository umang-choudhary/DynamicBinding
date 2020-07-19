package com.saifi369.dynamicbinding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.saifi369.dynamicbinding.R
import com.saifi369.dynamicbinding.model.User
import kotlinx.android.synthetic.main.item_call.view.*
import java.lang.IllegalArgumentException

private const val TYPE_CALL = 0
private const val TYPE_EMAIL = 1
private const val TYPE_MESSAGE = 2

class PersonAdapter(private val userList: List<User>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)

        return when(viewType){
            TYPE_CALL -> {
                val rootView = layoutInflater.inflate(R.layout.item_call,parent,false)
                CallViewHolder(rootView)
            }
            TYPE_EMAIL -> {
                val rootView = layoutInflater.inflate(R.layout.item_email,parent,false)
                EmailViewHolder(rootView)
            }
            TYPE_MESSAGE -> {
                val rootView =  layoutInflater.inflate(R.layout.item_message,parent,false)
                MessageViewHolder(rootView)
            }
            else -> throw IllegalArgumentException("Unknown view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = userList.get(position)

        when(getItemViewType(position)){
            TYPE_CALL->{
                val callViewHolder = holder as CallViewHolder
                callViewHolder.tvName.text = user.name
                callViewHolder.tvPhoneNo.text = user.phoneNo
            }
            TYPE_EMAIL->{
                val emailViewHolder = holder as EmailViewHolder
                emailViewHolder.tvName.text = user.name
                emailViewHolder.tvEmail.text = user.email
            }
            TYPE_MESSAGE->{
                val messageViewHolder = holder as MessageViewHolder
                messageViewHolder.tvName.text = user.name
                messageViewHolder.tvMessage.text = user.message
            }
        }
    }

    override fun getItemCount() = userList.size

    override fun getItemViewType(position: Int): Int {
        return userList.get(position).logType.ordinal
    }

    class CallViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val tvName:TextView = itemview.findViewById(R.id.tv_name)
        val tvPhoneNo:TextView = itemview.findViewById(R.id.tv_phone_no)
    }

    class EmailViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val tvName:TextView = itemview.findViewById(R.id.tv_name)
        val tvEmail:TextView = itemview.findViewById(R.id.tv_email)
    }

    class MessageViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val tvName:TextView = itemview.findViewById(R.id.tv_name)
        val tvMessage:TextView = itemview.findViewById(R.id.tv_message)
    }
}
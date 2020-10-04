package com.example.mvvmarchitecture.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmarchitecture.R
import com.example.mvvmarchitecture.databinding.AssignmentItemBinding
import com.example.mvvmarchitecture.server.response.Replies


class AssignmentAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var listOfItems: List<Replies>? = null

    constructor(listOfItems: List<Replies>?) : this() {
        this.listOfItems = listOfItems
    }

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): RecyclerView.ViewHolder {
        val binding: AssignmentItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.assignment_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listOfItems?.size!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyViewHolder) {
            var data: Replies = this!!.listOfItems!![position]
            if (data != null) {
                holder.bind(data)
            }
        }
    }

    class MyViewHolder(assignmentDetailsBinding: AssignmentItemBinding) :
        RecyclerView.ViewHolder(assignmentDetailsBinding.getRoot()) {
        var itemRowBinding: AssignmentItemBinding? = null

        init {
            this.itemRowBinding = assignmentDetailsBinding
        }

        fun bind(obj: Replies) {
            itemRowBinding?.assignmenItemtRes = obj
            itemRowBinding?.executePendingBindings()

        }
    }
}
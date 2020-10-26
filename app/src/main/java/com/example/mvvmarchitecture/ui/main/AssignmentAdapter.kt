package com.example.mvvmarchitecture.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmarchitecture.R
import com.example.mvvmarchitecture.base.ItemClickListener
import com.example.mvvmarchitecture.databinding.AssignmentItemBinding
import com.example.mvvmarchitecture.server.response.PagesData


class AssignmentAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var listOfItems: List<PagesData>? = null
    lateinit var clickListener : ItemClickListener

    constructor(listOfItems: List<PagesData>?, clickListener: ItemClickListener?) : this() {
        this.listOfItems = listOfItems
        this.clickListener = clickListener!!
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
            var data: PagesData = this!!.listOfItems!![position]
            var clickListener : ItemClickListener = this.clickListener!!
            holder.bind(data,clickListener)
        }
    }

    class MyViewHolder(assignmentDetailsBinding: AssignmentItemBinding) :
        RecyclerView.ViewHolder(assignmentDetailsBinding.getRoot()) {
        var itemRowBinding: AssignmentItemBinding? = null

        init {
            this.itemRowBinding = assignmentDetailsBinding
        }

        fun bind(obj: PagesData, clickListener: ItemClickListener? ) {
            itemRowBinding?.pageData = obj
            itemRowBinding?.executePendingBindings()
            itemRowBinding?.clickListener = clickListener

        }
    }
}
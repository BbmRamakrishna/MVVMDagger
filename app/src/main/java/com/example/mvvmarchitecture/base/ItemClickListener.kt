package com.example.mvvmarchitecture.base

import com.example.mvvmarchitecture.server.response.PagesData

interface  ItemClickListener{
    fun onItemSelected( item: PagesData?)
}
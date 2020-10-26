package com.example.mvvmarchitecture.server.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AssignmentResponse {


    @SerializedName("page")
    @Expose
    val page: String ? = null
    @SerializedName("per_page")
    @Expose
    val per_page: String ? = null
    @SerializedName("total")
    @Expose
    val total: String ? = null
    @SerializedName("total_pages")
    @Expose
    val total_pages: String ? = null
    @SerializedName("data")
    @Expose
    var data: List<PagesData>? = null
    @SerializedName("ad")
    @Expose
    val ad: Ad ? = null

}

class PagesData {

    @SerializedName("id")
    @Expose
    val id: String  ? = null
    @SerializedName("name")
    @Expose
    val name: String ? = null
    @SerializedName("year")
    @Expose
    val year: String ? = null
    @SerializedName("color")
    @Expose
    val color: String ? = null
    @SerializedName("pantone_value")
    @Expose
    val pantone_value: String ? = null
}

class Ad {

    @SerializedName("company")
    @Expose
    val company: String ? = null
    @SerializedName("url")
    @Expose
    val url: String ? = null
    @SerializedName("text")
    @Expose
    val text: String ? = null

}
package com.example.mvvmarchitecture.server.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AssignmentResponse {

    @SerializedName("username")
    @Expose
    val username : String ? = null
    @SerializedName("displayname")
    @Expose
    val displayname : String? = null
    @SerializedName("text")
    @Expose
    val text : String? = null
    @SerializedName("postedAt")
    @Expose
    val postedAt : String? = null
    @SerializedName("postLevel")
    @Expose
    val postLevel : Int? = null
    @SerializedName("likes")
    @Expose
    val likes : Int? = null
    @SerializedName("shares")
    @Expose
    val shares : Int? = null
    @SerializedName("replies")
    @Expose
    val replies : List<Replies>? = null
}

class Replies{
    @SerializedName("username")
    @Expose
    val username : String? = null
    @SerializedName("displayname")
    @Expose
    val displayname : String? = null
    @SerializedName("text")
    @Expose
    val text : String? = null
    @SerializedName("postedAt")
    @Expose
    val postedAt : String? = null
    @SerializedName("likes")
    @Expose
    val likes : Int? = null
    @SerializedName("shares")
    @Expose
    val shares : Int? = null
    @SerializedName("postLevel")
    @Expose
    val postLevel : Int? = null
    @SerializedName("replies")
    @Expose
    val replies : List<Replies>? = null
}
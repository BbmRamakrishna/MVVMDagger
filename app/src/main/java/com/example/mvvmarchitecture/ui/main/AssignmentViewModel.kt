package com.example.mvvmarchitecture.ui.main

import android.annotation.SuppressLint
import android.content.Context
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.example.mvvmarchitecture.R
import com.example.mvvmarchitecture.base.BaseViewModel
import com.example.mvvmarchitecture.base.MainArguments
import com.example.mvvmarchitecture.repository.IRepository
import com.example.mvvmarchitecture.server.Forecast
import com.example.mvvmarchitecture.server.response.Replies
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Named
import kotlin.collections.ArrayList

class AssignmentViewModel @Inject constructor(
    val context: Context,
//  @Named("arguments") var arguments: MainArguments,
    var repository: IRepository
) : BaseViewModel() {

    var assignmentAPICalled = ObservableBoolean(false)
    var repliesList = ObservableField<List<Replies>>()

    var userName = ObservableField("")
    var displayName =  ObservableField("")
    var displayText =  ObservableField("")
    var postedAt =  ObservableField("")
    var likes =  ObservableField("")
    var shares =  ObservableField("")
    var postlevel =  ObservableField("")


    fun callApi(){
            showDefaultLoader()
        repository.getAssignmentResonse().process(
            onSuccess = {
                dismissDefaultLoader()
                assignmentAPICalled.set(true)
                repliesList.set(it?.replies!!)
                userName.set(it.username)
                displayName.set(it.displayname)
                displayText.set(it.text)
                postedAt.set(it.postedAt)
                postlevel.set(it.postLevel.toString())
                likes.set(it.likes.toString())
                shares.set(it.shares.toString())


                println("==========$it======assignment_success=======")
                println("==========$userName=======")
                println("==========$displayName=======")


            },
            onFailure = {
                dismissDefaultLoader()
                handleError(it, callback = fun(_: String?) {
                    when (it) {
                        else -> {
                            println("==============assignment_failure===$it==============")
                        }
                    }
                })
            }
        )
    }


}
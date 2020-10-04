package com.example.mvvmarchitecture.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.mvvmarchitecture.base.AssignmentArguments
import com.example.mvvmarchitecture.base.BaseActivity
import com.example.mvvmarchitecture.databinding.AssignmentBinding
import com.example.mvvmarchitecture.ui.observe
import kotlin.reflect.KClass

class AssignmentActivity : BaseActivity<AssignmentViewModel, AssignmentBinding>() {
    override val layoutId: Int = com.example.mvvmarchitecture.R.layout.assignment

    override val viewModelClass: KClass<AssignmentViewModel> = AssignmentViewModel::class

    var adapter : AssignmentAdapter ? = null

    override fun navigate(navigateTo: String, arguments: Any?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.callApi()
        obserList()
    }

    private fun obserList() {


        viewModel.assignmentAPICalled.observe {
            if (it!!) {
                    this.runOnUiThread {
                        adapter = AssignmentAdapter(viewModel.repliesList.get())
                        binding.recyclerViewAssignmentDetails.adapter = adapter
                    }
            }
        }
    }

    companion object {

        fun createActivity(context: Context, arguments: AssignmentArguments): Intent {
            val i = Intent(context, AssignmentActivity::class.java)
            i.putExtra("arguments", arguments)
            return i
        }
    }
}

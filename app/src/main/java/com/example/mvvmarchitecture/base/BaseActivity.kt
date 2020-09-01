package com.example.mvvmarchitecture.base

import android.app.Dialog
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmarchitecture.R
import com.example.mvvmarchitecture.BR
import com.example.mvvmarchitecture.ui.observe
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseActivity<IViewModel : BaseViewModel, Binding : ViewDataBinding> :
    AppCompatActivity(), Navigator, HasSupportFragmentInjector {

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory
    protected abstract val layoutId: Int
    protected lateinit var binding: Binding
    protected abstract val viewModelClass: KClass<IViewModel>
    private var dialog: Dialog? = null

    protected val viewModel: IViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(viewModelClass.java)
    }

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> =
        fragmentDispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.setVariable(BR.viewModel, viewModel)
        viewModel.navigatorListener = this

        viewModel.systemAlertListener.observe {
            when (it) {
                ErrorTemplate.NO_INTERNET -> {
                    println("=================no_internet==============")
                }
                ErrorTemplate.DEFAULT_LOADER_SHOW -> {
                    showDialog()
                }
                ErrorTemplate.DEFAULT_LOADER_DISMISS -> {
                    cancelDialog()
                }
            }
            viewModel.systemAlertListener.set(ErrorTemplate.NONE)
        }

    }

    fun loadFragment(fragment: Fragment, frameContainerId: Int, expandToolbar: Boolean, collapsingToolbarLayout: CollapsingToolbarLayout, appBarLayout: AppBarLayout) {
        // load fragment

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(frameContainerId, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

        var lp: AppBarLayout.LayoutParams? = null
        if (expandToolbar) {
            appBarLayout.setExpanded(true)
            lp = collapsingToolbarLayout.layoutParams as AppBarLayout.LayoutParams
            lp.scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED
            collapsingToolbarLayout.layoutParams = lp

        } else {

            lp = collapsingToolbarLayout.layoutParams as AppBarLayout.LayoutParams
            lp.scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP
            collapsingToolbarLayout.layoutParams = lp
            appBarLayout.setExpanded(false)
        }
    }

    fun showDialog() {
        dialog = Dialog(this)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.setContentView(R.layout.progressbar)
        dialog?.setCancelable(false)
        dialog?.show()
    }

    fun cancelDialog() {
        if (dialog != null) {
            dialog?.dismiss()
        }
    }

}
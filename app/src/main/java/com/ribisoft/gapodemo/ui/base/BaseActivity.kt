package com.ribisoft.gapodemo.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.AndroidViewModel

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    abstract val layoutRes: Int
    abstract val viewModel: BaseViewModel
    lateinit var viewDataBinding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, layoutRes)
        viewDataBinding.lifecycleOwner = this
        initView()
        initEvent()
        observeData()
        observeDataFail()
    }

    abstract fun initView()

    abstract fun initEvent()

    abstract fun observeData()

    open fun observeDataFail() {

    }

    abstract fun onBack()

}
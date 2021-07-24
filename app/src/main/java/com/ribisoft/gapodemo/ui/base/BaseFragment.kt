package com.ribisoft.gapodemo.ui.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel

/**
 * Created by HuyNguyenCao on 3/15/2021.
 */
abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    abstract val layoutRes: Int
    abstract val viewModel: BaseViewModel
    lateinit var viewDataBinding: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        viewDataBinding.lifecycleOwner = this
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
}
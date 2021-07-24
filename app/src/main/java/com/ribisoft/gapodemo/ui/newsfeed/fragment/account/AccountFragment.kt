package com.ribisoft.gapodemo.ui.newsfeed.fragment.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ribisoft.gapodemo.R
import com.ribisoft.gapodemo.databinding.FragmentAccountBinding
import com.ribisoft.gapodemo.databinding.FragmentHomeBinding
import com.ribisoft.gapodemo.ui.base.BaseFragment
import com.ribisoft.gapodemo.ui.details.DetailsViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class AccountFragment : BaseFragment<FragmentAccountBinding>() {
    override val layoutRes: Int = R.layout.fragment_account
    override val viewModel by viewModel<DetailsViewModel>()

    companion object {
        @JvmStatic
        fun getInstance(): AccountFragment {
            return AccountFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        viewDataBinding.lifecycleOwner = this
        return viewDataBinding.root
    }


    override fun initView() {

    }

    override fun initEvent() {

    }

    override fun observeData() {

    }

}


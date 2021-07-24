package com.ribisoft.gapodemo.ui.newsfeed.fragment.account

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ribisoft.gapodemo.data.model.Item
import com.ribisoft.gapodemo.data.repo.HomeRepoImpl
import com.ribisoft.gapodemo.data.repo.NewsFeedRepoImpl
import com.ribisoft.gapodemo.ui.base.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created by HuyNguyenCao on 12/30/2020.
 */
class AccountViewModel(
    application: Application,
    private val repository: HomeRepoImpl
) : BaseViewModel(application) {
    override var errorMessage = MutableLiveData<String>()

}
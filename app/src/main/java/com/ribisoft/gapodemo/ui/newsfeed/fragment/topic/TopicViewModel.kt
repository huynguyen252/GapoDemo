package com.ribisoft.gapodemo.ui.newsfeed.fragment.topic

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ribisoft.gapodemo.data.model.Item
import com.ribisoft.gapodemo.data.repo.TopicRepoImpl
import com.ribisoft.gapodemo.ui.base.BaseViewModel
import com.ribisoft.gapodemo.utils.Constant.NO_INTERNET
import com.ribisoft.gapodemo.utils.Utils
import kotlinx.coroutines.*

/**
 * Created by HuyNguyenCao on 12/30/2020.
 */
class TopicViewModel(
    application: Application,
    private val repository: TopicRepoImpl
) : BaseViewModel(application) {

    override var errorMessage = MutableLiveData<String>()
    var itemList = MutableLiveData<List<Item>>()

    fun getItemList() {
        coroutineScope.launch {
            try {
                if (Utils.hasInternetConnection(getApplication())) {
                    val response = repository.getNewsFeed()
                    if (response.isSuccessful) {
                        response.body()?.let {
                            itemList.postValue(it.items!!)
                        }
                        errorMessage.postValue(null)
                    } else {
                        errorMessage.postValue(response.message())
                    }
                } else {
                    errorMessage.postValue(NO_INTERNET)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }

}
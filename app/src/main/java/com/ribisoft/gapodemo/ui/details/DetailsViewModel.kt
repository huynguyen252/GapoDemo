package com.ribisoft.gapodemo.ui.details

import android.app.Application
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ribisoft.gapodemo.data.model.Item
import com.ribisoft.gapodemo.data.repo.DetailsRepoImpl
import com.ribisoft.gapodemo.ui.base.BaseViewModel
import com.ribisoft.gapodemo.utils.Constant.NO_INTERNET
import com.ribisoft.gapodemo.utils.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by HuyNguyenCao on 12/30/2020.
 */
class DetailsViewModel(
    application: Application,
    private val repository: DetailsRepoImpl
) : BaseViewModel(application) {

    override var errorMessage = MutableLiveData<String>()
    var item = MutableLiveData<Item>()

    fun getDetailList() {
        coroutineScope.launch {
            try {
                if (Utils.hasInternetConnection(getApplication())) {
                    val response = repository.getDetails()
                    if (response.isSuccessful) {
                        response.body()?.let {
                            item.postValue(response.body())
                            errorMessage.postValue(null)
                        }
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

}
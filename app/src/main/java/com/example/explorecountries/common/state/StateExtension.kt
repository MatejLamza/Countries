package com.example.explorecountries.common.state

import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.observe
import com.example.explorecountries.common.View
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


fun <T> LiveData<Resource<T>>.observe(
    owner: LifecycleOwner,
    view: View? = null,
    onError: ((error: Throwable) -> Unit)? = null,
    onLoading: ((T?) -> Unit)? = null,
    onSuccess: ((T) -> Unit)? = null
) = observe(owner) { resource ->
    when (resource) {
        is Resource.Success -> {
            view?.dismissLoading()
            onSuccess?.invoke(resource.data!!)
        }
        is Resource.Error -> {
            if (onError != null) {
                onError.invoke(resource.exception)
            } else {
                view?.dismissLoading()
                view?.showError(resource.exception)
            }
        }
        is Resource.Loading -> onLoading?.invoke(resource.data)
            ?: view?.showLoading()
    }
}

fun <T> ViewModel.errorHandler(data: MutableLiveData<Resource<T>>? = null) =
    CoroutineExceptionHandler { _, exception ->
        Log.e("ViewModel", "Error in ViewModel", exception)
        data?.postValue(Resource.Error(exception, null))
    }

fun <T> ViewModel.launch(
    data: MutableLiveData<Resource<T>>,
    context: CoroutineContext = errorHandler(data),
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
) = viewModelScope.launch(context, start) {
    data.postValue(Resource.Loading(data.value?.data))
    block(this)
}

fun ViewModel.launch(
    context: CoroutineContext = errorHandler<Any>(null),
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
) = viewModelScope.launch(context, start) {
    block(this)
}

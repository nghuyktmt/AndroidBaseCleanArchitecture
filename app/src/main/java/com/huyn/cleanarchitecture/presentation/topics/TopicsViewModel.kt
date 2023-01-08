package com.huyn.cleanarchitecture.presentation.topics

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import com.huyn.cleanarchitecture.domain.models.Topic
import com.huyn.cleanarchitecture.domain.usecase.GetTopics
import com.huyn.cleanarchitecture.presentation.base.BaseViewModel
import com.huyn.cleanarchitecture.utils.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopicsViewModel @Inject constructor(getTopics: GetTopics) :
    BaseViewModel() {

    val deleteEvent = MutableStateFlow(0L)

    val topics = getTopics.invoke(Unit).cachedIn(viewModelScope)
        .combine(deleteEvent) { data: PagingData<Topic>, event: Long ->
            Logger.d("Combine: $event")
            data.filter {
                if (event > 0) {
                    it.title.startsWith("F")
                } else {
                    true
                }
            }
        }

    fun testDelete() {
        viewModelScope.launch {
            deleteEvent.value++
        }
    }

}
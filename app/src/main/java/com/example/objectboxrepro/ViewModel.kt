package com.example.objectboxrepro

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.common.BoxObject
import com.example.common.MyObjectBox
import io.objectbox.Box
import io.objectbox.query.Query
import io.objectbox.android.ObjectBoxDataSource

class ViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var liveDataPaged: LiveData<PagedList<BoxObject>>
    val boxObject: Box<BoxObject>

    init {
        val boxstore = MyObjectBox.builder().androidContext(application).build()
        boxObject = boxstore.boxFor(BoxObject::class.java)
    }

    fun ViewModel() {
        val query: Query<BoxObject> = boxObject.query().build()
        liveDataPaged = LivePagedListBuilder(
            ObjectBoxDataSource.Factory(query),
            PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(10)
                .build() /* page size */
        ).build()
    }

}
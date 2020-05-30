package by.tms.presentation.mvp.startscreen

import android.text.Editable
import by.tms.domain.models.Country

import io.reactivex.disposables.CompositeDisposable

interface StartScreenPresenter {
    fun onLoadData()
    fun onPerformSearch(startList: ArrayList<Country>, searchList: ArrayList<Country>, t: Editable?)
    fun onDispose()
}
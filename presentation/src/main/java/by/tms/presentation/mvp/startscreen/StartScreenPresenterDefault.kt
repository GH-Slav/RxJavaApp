package by.tms.presentation.mvp.startscreen

import android.text.Editable
import by.tms.domain.covid.CovidInteractor
import by.tms.domain.models.Country

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class StartScreenPresenterDefault(val view: StartScreenView): StartScreenPresenter {
    val compositeDisposable = CompositeDisposable()
    override fun onLoadData() {
        val disposable = CovidInteractor().getAllCountries()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.setupStartList(it)
                view.setupRecycler(it)
            }, {

            })

        compositeDisposable.add(disposable)
    }

    override fun onPerformSearch(
        startList: ArrayList<Country>,
        searchList: ArrayList<Country>,
        t: Editable?
    ) {
        searchList.clear()
        if (t.toString().isEmpty()) {
            view.setupRecycler(startList)
        } else {
            startList.forEach {item ->
                if (item.country.toLowerCase().contains(t.toString().toLowerCase())) {
                    searchList.add(item)
                }
            }
            view.setupRecycler(searchList)
        }
    }

    override fun onDispose() {
        compositeDisposable.dispose()
    }
}
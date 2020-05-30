package by.tms.presentation.mvp.startscreen
import by.tms.domain.models.Country
import io.reactivex.disposables.CompositeDisposable

interface StartScreenView {
    fun setupRecycler(countriesList: ArrayList<Country>)
    fun setupStartList(countriesList: ArrayList<Country>)
}
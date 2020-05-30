package by.tms.presentation.ui.startscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import by.tms.domain.models.Country
import by.tms.presentation.AdapterCountries
import by.tms.presentation.R
import by.tms.presentation.mvp.startscreen.StartScreenPresenterDefault
import by.tms.presentation.mvp.startscreen.StartScreenView


import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*

class StartScreenActivity: AppCompatActivity(), StartScreenView {
    private var startList = ArrayList<Country>()
    private val searchList = ArrayList<Country>()
    private val presenter = StartScreenPresenterDefault(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText.doAfterTextChanged {
            presenter.onPerformSearch(startList, searchList, it)
        }

        showStatsButton.setOnClickListener {
            presenter.onLoadData()
        }
    }

    override fun setupRecycler(countriesList: ArrayList<Country>) {
        recyclerView.adapter = AdapterCountries(countriesList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
    }

    override fun setupStartList(countriesList: ArrayList<Country>) {
        startList = countriesList
    }

    override fun onDestroy() {
        presenter.onDispose()
        super.onDestroy()
    }
}
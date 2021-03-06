package by.tms.rxjavaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.tms.rxjavaapp.retrofit.Country
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_recycler_countries.view.*


class AdapterCountries(val list: List<Country>) :
    RecyclerView.Adapter<AdapterCountries.CountriesViewHolder>() {
    class CountriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_countries, parent, false)

        return CountriesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        val view = holder.itemView

        Picasso.get().load(list[position].countryFlagUrl).into(view.flagImage)

        view.countryName.text = list[position].country
        view.totalConfirmed.text = list[position].totalConfirmed.toString()
            .plus(" " + view.resources.getString(R.string.confirmed))
        view.totalDead.text = list[position].totalDeaths.toString()
            .plus(" " + view.resources.getString(R.string.dead))
        view.totalRecovered.text = list[position].totalRecovered.toString()
            .plus(" " + view.resources.getString(R.string.recovered))

    }


}
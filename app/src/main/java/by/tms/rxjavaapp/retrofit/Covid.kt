package by.tms.rxjavaapp.retrofit


import com.google.gson.annotations.SerializedName

data class Covid(
    @SerializedName("Countries")
    val countries: List<Country>,
    @SerializedName("Date")
    val date: String,
    @SerializedName("Global")
    val global: Global
)
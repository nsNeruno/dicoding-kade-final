package dev.neruno.lab.footballapps.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Event(

    @SerializedName("idEvent")
    var id: String? = null,

    @SerializedName("strEvent")
    var event: String? = null,

    @SerializedName("strHomeTeam")
    var homeTeam: String? = null,

    @SerializedName("strAwayTeam")
    var awayTeam: String? = null,

    @SerializedName("intHomeScore")
    var homeScore: String? = null,

    @SerializedName("intAwayScore")
    var awayScore: String? = null,

    @SerializedName("strHomeGoalDetails")
    var homeGoalDetails: String? = null,

    @SerializedName("strHomeLineupGoalkeeper")
    var homeGoalkeeper: String? = null,

    @SerializedName("strHomeLineupDefense")
    var homeDefense: String? = null,

    @SerializedName("strAwayGoalDetails")
    var awayGoalDetails: String? = null,

    @SerializedName("strAwayLineupGoalkeeper")
    var awayGoalkeeper: String? = null,

    @SerializedName("strAwayLineupDefense")
    var awayDefense: String? = null

) : Parcelable

data class Events(
    @SerializedName("events", alternate = ["event"])
    var events: List<Event>? = null
)
package dev.neruno.lab.footballapps.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import dev.neruno.lab.footballapps.utilities.Utilities
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

    @SerializedName("strHomeLineupMidfield")
    var homeMidfield: String? = null,

    @SerializedName("strHomeLineupForward")
    var homeForward: String? = null,

    @SerializedName("strHomeLineupSubstitutes")
    var homeSubstitutes: String? = null,

    @SerializedName("strHomeFormation")
    var homeFormation: String? = null,

    @SerializedName("strAwayGoalDetails")
    var awayGoalDetails: String? = null,

    @SerializedName("strAwayLineupGoalkeeper")
    var awayGoalkeeper: String? = null,

    @SerializedName("strAwayLineupDefense")
    var awayDefense: String? = null,

    @SerializedName("strAwayLineupMidfield")
    var awayMidfield: String? = null,

    @SerializedName("strAwayLineupForward")
    var awayForward: String? = null,

    @SerializedName("strAwayLineupSubstitutes")
    var awaySubstitutes: String? = null,

    @SerializedName("strAwayFormation")
    var awayFormation: String? = null,

    @SerializedName("intHomeShots")
    var homeShots: String? = null,

    @SerializedName("intAwayShots")
    var awayShots: String? = null,

    @SerializedName("dateEvent")
    var date: String? = null, // sample: 2018-11-30

    @SerializedName("strTime")
    var time: String? = "20:00:00+00:00", // sample 20:00:00+00:00

    @SerializedName("idHomeTeam")
    var homeId: String? = null,

    @SerializedName("idAwayTeam")
    var awayId: String? = null

) : Parcelable {

    fun getShortDate(): String {
        date?.let {
            return Utilities.reformatDateString(it, "yyyy-MM-dd", "EE, dd MMM yyyy")
        } ?: run {
            return date.toString()
        }
    }

    fun getShortTime(): String {
        time?.let {
            return it.substring(IntRange(0, 4))
        } ?: run {
            return time.toString()
        }
    }

    fun getScores(): String {
        if (homeScore == null || awayScore == null) {
            return "vs"
        }
        return "$homeScore vs $awayScore"
    }
}

data class Events(
    @SerializedName("events", alternate = ["event"])
    var events: List<Event>? = null
)
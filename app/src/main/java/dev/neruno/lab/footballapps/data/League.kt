package dev.neruno.lab.footballapps.data

import com.google.gson.annotations.SerializedName

data class League(

    @SerializedName("idLeague")
    var id: String? = null,

    @SerializedName("strLeague")
    var name: String? = null

) {
    override fun toString(): String {
        return name.toString()
    }
}

data class Leagues(

    @SerializedName("countrys")
    var leagues: List<League>? = null
)
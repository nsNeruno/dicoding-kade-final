package dev.neruno.lab.footballapps.data

import com.google.gson.annotations.SerializedName

data class Team(

    @SerializedName("idTeam")
    var id: String? = null,

    @SerializedName("strTeam")
    var name: String? = null,

    @SerializedName("intFormedYear")
    var formedYear: String? = null,

    @SerializedName("strStadium")
    var stadium: String? = null,

    @SerializedName("strDescriptionEN")
    var description: String? = null,

    @SerializedName("strTeamBadge")
    var badge: String? = null
)

data class Teams(
    @SerializedName("teams")
    var teams: List<Team>? = null
)
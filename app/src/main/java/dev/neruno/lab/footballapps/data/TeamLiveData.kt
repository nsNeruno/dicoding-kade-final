package dev.neruno.lab.footballapps.data

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamLiveData(private val teamId: String) : LiveData<List<Team>?>() {

    init {
        SportsDbRepository.callTeamLookupRepository(teamId, object : Callback<Teams> {
            override fun onFailure(call: Call<Teams>, t: Throwable) {
                value = null
            }

            override fun onResponse(call: Call<Teams>, response: Response<Teams>) {
                value = if (response.isSuccessful) {
                    response.body()?.teams
                } else {
                    null
                }
            }
        })
    }
}
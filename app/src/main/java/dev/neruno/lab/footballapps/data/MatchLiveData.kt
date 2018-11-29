package dev.neruno.lab.footballapps.data

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MatchLiveData(
    private var leagueId: String? = null,
    private var type: String? = null
) : LiveData<List<Event>?>() {

    private val callback = object : Callback<Events> {
        override fun onFailure(call: Call<Events>, t: Throwable) {
            value = null
        }

        override fun onResponse(call: Call<Events>, response: Response<Events>) {
            value = if (response.isSuccessful) {
                response.body()?.events
            } else {
                null
            }
        }
    }

    private fun callRepository() {
        when (type?.toLowerCase()) {
            "next" -> {
                SportsDbRepository.callNextMatchesRepository(leagueId, callback)
            }
            "past" -> {
                SportsDbRepository.callPastMatchesRepository(leagueId, callback)
            }
            else -> {
                value = null
            }
        }
    }

    init {
        callRepository()
    }

    fun changeLeague(leagueId: String) {
        this.leagueId = leagueId
        callRepository()
    }
}
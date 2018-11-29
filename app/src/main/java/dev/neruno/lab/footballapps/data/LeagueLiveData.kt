package dev.neruno.lab.footballapps.data

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LeagueLiveData : LiveData<List<League>?>() {

    init {
        SportsDbRepository.callLeagueApiRepository(object : Callback<Leagues> {
            override fun onFailure(call: Call<Leagues>, t: Throwable) {
                value = null
            }

            override fun onResponse(call: Call<Leagues>, response: Response<Leagues>) {
                value = if (response.isSuccessful) {
                    response.body()?.leagues
                } else {
                    null
                }
            }
        })
    }
}
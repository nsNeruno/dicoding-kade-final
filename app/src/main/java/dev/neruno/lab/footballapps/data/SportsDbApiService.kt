package dev.neruno.lab.footballapps.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface SportsDbApiService {

    companion object {
        val instance: SportsDbApiService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
                .build()
            retrofit.create(SportsDbApiService::class.java)
        }
    }

    @GET("eventsnextleague.php")
    fun getNextMatches(@Query("id") leagueId: String) : Call<Events>

    @GET("eventspastleague.php")
    fun getPastMatches(@Query("id") leagueId: String) : Call<Events>
}
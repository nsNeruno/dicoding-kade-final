package dev.neruno.lab.footballapps.data

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface SportsDbApiService {

    companion object {
        val instance: SportsDbApiService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .build()
            retrofit.create(SportsDbApiService::class.java)
        }
    }

    @GET("search_all_leagues.php?s=Soccer")
    fun getLeagues() : Call<Leagues>

    @GET("eventsnextleague.php")
    fun getNextMatches(@Query("id") leagueId: String?) : Call<Events>

    @GET("eventspastleague.php")
    fun getPastMatches(@Query("id") leagueId: String?) : Call<Events>

    @GET("lookupteam.php")
    fun getTeam(@Query("id") teamId: String?) : Call<Teams>
}
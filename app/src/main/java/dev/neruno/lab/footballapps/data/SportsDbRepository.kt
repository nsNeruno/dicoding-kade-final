package dev.neruno.lab.footballapps.data

import retrofit2.Callback

class SportsDbRepository {

    companion object {

        @JvmStatic
        fun callLeagueApiRepository(callback: Callback<Leagues>) {
            SportsDbApiService.instance.getLeagues().enqueue(callback)
        }

        @JvmStatic
        fun callNextMatchesRepository(leagueId: String?, callback: Callback<Events>) {
            SportsDbApiService.instance.getNextMatches(leagueId).enqueue(callback)
        }

        @JvmStatic
        fun callPastMatchesRepository(leagueId: String?, callback: Callback<Events>) {
            SportsDbApiService.instance.getPastMatches(leagueId).enqueue(callback)
        }

        @JvmStatic
        fun callTeamLookupRepository(teamId: String?, callback: Callback<Teams>) {
            SportsDbApiService.instance.getTeam(teamId).enqueue(callback)
        }
    }
}
package dev.neruno.lab.footballapps.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel;
import dev.neruno.lab.footballapps.data.Team
import dev.neruno.lab.footballapps.data.TeamLiveData

class MatchDetailViewModel : ViewModel() {

    fun getTeam(id: String): LiveData<List<Team>?> {
        return TeamLiveData(id)
    }
}

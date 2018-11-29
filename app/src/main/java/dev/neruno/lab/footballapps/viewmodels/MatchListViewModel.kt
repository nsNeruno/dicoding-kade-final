package dev.neruno.lab.footballapps.viewmodels

import android.widget.AdapterView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.neruno.lab.footballapps.data.*

class MatchListViewModel : ViewModel() {

    private val nextMatches = MatchLiveData(type = "next")
    private val nextMatchesSelectedLeagueIndex = MutableLiveData<Int>().apply { value = 0 }

    private val pastMatches = MatchLiveData(type = "past")
    private val pastMatchesSelectedLeagueIndex = MutableLiveData<Int>().apply { value = 0 }

    private val leagues: LiveData<List<League>?>

    init {
        leagues = LeagueLiveData()
    }

    fun loadLeagues(): LiveData<List<League>?> {
        return leagues
    }

    fun loadMatches(parent: AdapterView<*>, type: String?) {
        val item = parent.selectedItem
        if (item is League) {
            item.id?.let {
                when(type) {
                    "next" -> {
                        nextMatches.changeLeague(it)
                    }
                    "past" -> {
                        pastMatches.changeLeague(it)
                    }
                    else -> {

                    }
                }
            }
        }
    }

    fun getNextMatches(): LiveData<List<Event>?> {
        return nextMatches
    }

    fun getNextMatchesCurrentLeagueIndex(): LiveData<Int> {
        return nextMatchesSelectedLeagueIndex
    }

    fun getPastMatches(): LiveData<List<Event>?> {
        return pastMatches
    }

    fun getPastMatchesCurrentLeagueIndex(): LiveData<Int> {
        return pastMatchesSelectedLeagueIndex
    }

    fun rememberMatchesLeagueIndex(type: String?, index: Int) {
        when(type) {
            "next" -> {
                nextMatchesSelectedLeagueIndex.value = index
            }
            "past" -> {
                pastMatchesSelectedLeagueIndex.value = index
            }
            else -> {

            }
        }
    }
}

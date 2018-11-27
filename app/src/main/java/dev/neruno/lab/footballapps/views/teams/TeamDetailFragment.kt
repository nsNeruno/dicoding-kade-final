package dev.neruno.lab.footballapps.views.teams

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import dev.neruno.lab.footballapps.R
import dev.neruno.lab.footballapps.viewmodels.TeamDetailViewModel

class TeamDetailFragment : Fragment() {

    companion object {
        fun newInstance() = TeamDetailFragment()
    }

    private lateinit var viewModel: TeamDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.team_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TeamDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}

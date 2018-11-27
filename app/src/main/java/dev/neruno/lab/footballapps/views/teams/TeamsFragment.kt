package dev.neruno.lab.footballapps.views.teams

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import dev.neruno.lab.footballapps.R
import dev.neruno.lab.footballapps.viewmodels.TeamsViewModel

class TeamsFragment : Fragment() {

    companion object {
        fun newInstance() = TeamsFragment()
    }

    private lateinit var viewModel: TeamsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.teams_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TeamsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}

package dev.neruno.lab.footballapps.views.matches

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import dev.neruno.lab.footballapps.R
import dev.neruno.lab.footballapps.viewmodels.MatchDetailViewModel

class MatchDetailFragment : Fragment() {

    companion object {
        fun newInstance() = MatchDetailFragment()
    }

    private lateinit var viewModel: MatchDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.match_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MatchDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}

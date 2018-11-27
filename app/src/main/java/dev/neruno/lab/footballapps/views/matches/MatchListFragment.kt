package dev.neruno.lab.footballapps.views.matches

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import dev.neruno.lab.footballapps.R
import dev.neruno.lab.footballapps.databinding.MatchListFragmentBinding
import dev.neruno.lab.footballapps.viewmodels.MatchListViewModel

class MatchListFragment : Fragment() {

    companion object {
        fun newInstance() = MatchListFragment()
    }

    private lateinit var binding: MatchListFragmentBinding
    private lateinit var viewModel: MatchListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MatchListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MatchListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}

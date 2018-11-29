package dev.neruno.lab.footballapps.views.matches

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import dev.neruno.lab.footballapps.NavMainDirections

import dev.neruno.lab.footballapps.R
import dev.neruno.lab.footballapps.adapters.RecyclerViewAdapter
import dev.neruno.lab.footballapps.data.Event
import dev.neruno.lab.footballapps.databinding.ItemMatchBinding
import dev.neruno.lab.footballapps.databinding.MatchListFragmentBinding
import dev.neruno.lab.footballapps.viewmodels.MatchListViewModel

class MatchListFragment : Fragment() {

    companion object {
        fun newInstance(type: String) = MatchListFragment().apply {
            arguments = Bundle().apply {
                putString("type", type)
            }
        }
    }

    private var type: String? = null

    private lateinit var binding: MatchListFragmentBinding
    private lateinit var leaguePicker: Spinner
    private lateinit var viewModel: MatchListViewModel

    private fun observeMatches() {
        val matchLiveData = when (type) {
            "next" -> {
                viewModel.getNextMatches()
            }
            "past" -> {
                viewModel.getPastMatches()
            }
            else -> {
                return
            }
        }

        matchLiveData.observe(viewLifecycleOwner, Observer { eventList ->
            eventList?.let { events ->
                binding.adapter = RecyclerViewAdapter<Event, ItemMatchBinding>(events, R.layout.item_match,
                    onBindItem =  { binding, event ->
                        binding.event = event
                    },
                    onItemClick = { event ->
                        viewModel.rememberMatchesLeagueIndex(type, binding.spinnerLeagueMatchList.selectedItemPosition)
                        Navigation.findNavController(requireActivity(), R.id.main_container_fragment).navigate(
                            NavMainDirections.ActionViewEvent(event)
                        )
                    })
            }
        })
    }

    private fun observeSelectedLeague() {
        val indexLiveData = when (type) {
            "next" -> {
                viewModel.getNextMatchesCurrentLeagueIndex()
            }
            "past" -> {
                viewModel.getPastMatchesCurrentLeagueIndex()
            }
            else -> {
                return
            }
        }
        indexLiveData.observe(viewLifecycleOwner, Observer {
            binding.selectedLeagueIndex = it

            observeMatches()
        })
    }

    private fun observeLeagues() {
        viewModel.loadLeagues().observe(viewLifecycleOwner, Observer {
            it?.let { leagues ->
                binding.leagueAdapter =
                        ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, leagues).apply { setNotifyOnChange(true) }
                observeSelectedLeague()
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        type = arguments?.getString("type")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MatchListFragmentBinding.inflate(inflater, container, false)
        binding.type = type
        binding.recyclerMatchList.apply {
            itemAnimator = DefaultItemAnimator()
            layoutManager = LinearLayoutManager(requireContext())
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity()).get(MatchListViewModel::class.java)
        binding.viewModel = viewModel

        observeLeagues()
    }
}

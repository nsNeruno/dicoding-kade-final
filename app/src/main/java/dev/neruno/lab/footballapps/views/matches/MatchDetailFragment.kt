package dev.neruno.lab.footballapps.views.matches

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide

import dev.neruno.lab.footballapps.R
import dev.neruno.lab.footballapps.data.Event
import dev.neruno.lab.footballapps.databinding.MatchDetailFragmentBinding
import dev.neruno.lab.footballapps.utilities.Utilities
import dev.neruno.lab.footballapps.viewmodels.MatchDetailViewModel

class MatchDetailFragment : Fragment() {

    companion object {
        fun newInstance() = MatchDetailFragment()
    }

    private var event: Event? = null

    private lateinit var binding: MatchDetailFragmentBinding
    private lateinit var viewModel: MatchDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        event = arguments?.getParcelable("event")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MatchDetailFragmentBinding.inflate(inflater, container, false)
        binding.event = event

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MatchDetailViewModel::class.java)

        val homeId = event?.homeId
        val awayId = event?.awayId

        if (homeId != null && awayId != null) {
            viewModel.getTeam(homeId).observe(viewLifecycleOwner, Observer {
                it?.let { teams ->
                    if (teams.isNotEmpty()) {
                        val team = teams[0]
                        Glide.with(this).load(team.badge).into(binding.imageMatchDetailHome)
                    }
                }
            })

            viewModel.getTeam(awayId).observe(viewLifecycleOwner, Observer {
                it?.let { teams ->
                    if (teams.isNotEmpty()) {
                        val team = teams[0]
                        Glide.with(this).load(team.badge).into(binding.imageMatchDetailAway)
                    }
                }
            })
        }
    }

}

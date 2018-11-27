package dev.neruno.lab.footballapps.views.matches

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

import dev.neruno.lab.footballapps.R
import dev.neruno.lab.footballapps.adapters.ViewPagerAdapter
import dev.neruno.lab.footballapps.databinding.MatchesFragmentBinding
import dev.neruno.lab.footballapps.viewmodels.MatchesViewModel

class MatchesFragment : Fragment() {

    companion object {
        fun newInstance() = MatchesFragment()
    }

    private lateinit var matchesTab: TabLayout
    private lateinit var viewPager: ViewPager
    private val previousMatchFragment: MatchListFragment = MatchListFragment.newInstance()
    private val nextMatchFragment: MatchListFragment = MatchListFragment.newInstance()

    private lateinit var binding: MatchesFragmentBinding
    private lateinit var viewModel: MatchesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MatchesFragmentBinding.inflate(inflater, container, false)

        matchesTab = binding.tabMatches
        viewPager = binding.viewPagerMatches.apply {
            adapter = ViewPagerAdapter(childFragmentManager, listOf(
                Pair("Next", nextMatchFragment),
                Pair("Previous", previousMatchFragment)
            ))
        }

        matchesTab.setupWithViewPager(viewPager)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MatchesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}

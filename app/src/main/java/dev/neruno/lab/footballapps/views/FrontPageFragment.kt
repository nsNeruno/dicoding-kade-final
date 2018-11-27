package dev.neruno.lab.footballapps.views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI

import dev.neruno.lab.footballapps.R
import dev.neruno.lab.footballapps.databinding.FrontPageFragmentBinding
import dev.neruno.lab.footballapps.viewmodels.FrontPageViewModel

class FrontPageFragment : Fragment() {

    companion object {
        fun newInstance() = FrontPageFragment()
    }

    private lateinit var binding: FrontPageFragmentBinding
    private lateinit var viewModel: FrontPageViewModel
    private lateinit var frontPageNavController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrontPageFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        frontPageNavController = Navigation.findNavController(requireActivity(), R.id.front_page_container_fragment)
        NavigationUI.setupWithNavController(binding.bottomNavigationFrontPage, frontPageNavController)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FrontPageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}

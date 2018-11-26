package dev.neruno.lab.footballapps.views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import dev.neruno.lab.footballapps.R

class FrontPageFragment : Fragment() {

    companion object {
        fun newInstance() = FrontPageFragment()
    }

    private lateinit var viewModel: FrontPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.front_page_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FrontPageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}

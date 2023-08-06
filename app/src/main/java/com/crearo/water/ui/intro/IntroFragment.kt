package com.crearo.water.ui.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.crearo.water.databinding.FragmentIntroBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IntroFragment : Fragment() {
    private val viewModel: PermissionsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = FragmentIntroBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.navigation.observe(viewLifecycleOwner) {
            it.getNavIfNotHandled()?.let { nav -> findNavController().navigate(nav) }
        }
        return binding.root
    }

}
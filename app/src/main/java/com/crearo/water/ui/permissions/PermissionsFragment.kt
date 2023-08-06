package com.crearo.water.ui.permissions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.crearo.water.databinding.FragmentPermissionsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PermissionsFragment : Fragment() {
    private val viewModel: PermissionsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPermissionsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.navigation.observe(viewLifecycleOwner) {
            it.getNavIfNotHandled()?.let { nav -> findNavController().navigate(nav) }
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadUi()
        viewModel.navigateIfComplete()
    }

}
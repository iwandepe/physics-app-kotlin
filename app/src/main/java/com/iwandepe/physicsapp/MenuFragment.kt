package com.iwandepe.physicsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.iwandepe.physicsapp.databinding.FragmentLoginBinding
import com.iwandepe.physicsapp.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentMenuBinding>(inflater, R.layout.fragment_menu, container, false)
        binding.apply {
            countingAreaNavigation.setOnClickListener { v: View ->
                v.findNavController().navigate(R.id.action_menuFragment_to_countAreaFragment)
            }
            countingVolumeNavigation.setOnClickListener { v: View ->
                v.findNavController().navigate(R.id.action_menuFragment_to_countVolumeFragment)
            }
            lengthConversionNavigation.setOnClickListener{ v: View ->
                v.findNavController().navigate(R.id.action_menuFragment_to_conversionFragment)
            }
        }
        return binding.root
    }
}
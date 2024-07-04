package com.itis.myApp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.itis.myApp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var binding: FragmentProfileBinding? = null
    private var adapter: CarAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        adapter = CarAdapter(
            list = CarRepository.list,
            glide = Glide.with(this),
            onItemClick = { fruit ->
                findNavController().navigate(
                    R.id.action_profileFragment_to_informationFragment,
                    InformationFragment.createBundle(fruit.id)
                )
            }
        )
        binding?.rvFruit?.adapter = adapter
    }
}
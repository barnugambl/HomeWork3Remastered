package com.itis.myApp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.itis.myApp.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment(R.layout.fragment_history) {
    private var binding: FragmentHistoryBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHistoryBinding.bind(view)

        binding?.run {
            btnToHidden.setOnClickListener {
                findNavController().navigate(R.id.action_historyFragment_to_hiddenFragment)
                val name : String = "com.itis.myApp.HistoryFragment"
                binding?.root?.let { it1 -> Snackbar.make(it1, "We are here from $name", Snackbar.LENGTH_LONG).show() }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
package com.itis.myApp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.itis.myApp.databinding.FragmentInfoBinding

class InformationFragment : Fragment(R.layout.fragment_info) {
    private var binding: FragmentInfoBinding? = null
    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.ALL)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInfoBinding.bind(view)
        binding?.btnToProfileFragment?.setOnClickListener {
            findNavController().navigateUp()
        }
        val fruit = getInfo()
        setInfo(fruit)
        setImage(fruit)
    }

    @SuppressLint("SetTextI18n")
    private fun setInfo(car: Car) {
        with(binding) {
            this?.id?.text = "Model: ${car.model}"
            this?.name?.text = "Name: ${car.brand}"
            this?.desc?.text = "Desc: ${car.longDescription}"
        }
    }

    private fun getInfo(): Car {
        val id = arguments?.getInt(ID)
        return CarRepository.list.single { it.id == id }
    }

    private fun setImage(car: Car) {
        binding?.imageView?.let {
            Glide.with(this)
                .load(car.url)
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .apply(options)
                .into(binding!!.imageView)
        }
    }

    companion object {
        private const val ID = "ARG_ID"

        fun createBundle(id: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt(ID, id)
            return bundle
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
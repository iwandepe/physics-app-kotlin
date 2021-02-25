package com.iwandepe.physicsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.iwandepe.physicsapp.databinding.FragmentCountAreaBinding
import com.iwandepe.physicsapp.databinding.FragmentCountVolumeBinding

class CountVolumeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentCountVolumeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_count_volume, container, false
        )
        val lengthEditText: EditText = binding.lengthVolumeInput
        val widthEditText: EditText = binding.widthVolumeInput
        val heightEditText: EditText = binding.heightVolumeInput
        val resultVolumeText: TextView = binding.resultVolumeText

        binding.countVolumeButton.setOnClickListener {
            val length: String = lengthEditText.text.toString()
            val width: String = widthEditText.text.toString()
            val height: String = heightEditText.text.toString()

            // validation length and width input
            if (length.isEmpty()){
                lengthEditText.error = "Length cannot be empty"
            }
            if (width.isEmpty()){
                widthEditText.error = "Width cannot be empty"
            }
            if (height.isEmpty()){
                heightEditText.error = "Height cannot be empty"
            }

            if (!length.isEmpty() && !width.isEmpty() && !height.isEmpty()){
                val result: Double = length.toDouble() * width.toDouble() * height.toDouble()
                resultVolumeText.text = result.toString()
                resultVolumeText.visibility = View.VISIBLE
            }
        }
        return binding.root
    }
}
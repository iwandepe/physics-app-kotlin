package com.iwandepe.physicsapp

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.iwandepe.physicsapp.databinding.FragmentCountAreaBinding

class CountAreaFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentCountAreaBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_count_area, container, false
        )
        val lengthEditText: EditText = binding.lengthAreaInput
        val widthEditText: EditText = binding.widthAreaInput
        val resultAreaText: TextView = binding.resultAreaText

        binding.countAreaButton.setOnClickListener {
            val length: String = lengthEditText.text.toString()
            val width: String = widthEditText.text.toString()

            // validation length and width input
            if (length.isEmpty()){
                lengthEditText.error = "Length cannot be empty"
            }
            if (width.isEmpty()){
                widthEditText.error = "Width cannot be empty"
            }

            if (!length.isEmpty() && !width.isEmpty()){
                val result: Double = length.toDouble() * width.toDouble()
                resultAreaText.text = result.toString()
                resultAreaText.visibility = View.VISIBLE
            }
        }
        return binding.root
    }

}
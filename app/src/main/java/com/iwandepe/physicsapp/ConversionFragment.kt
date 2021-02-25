package com.iwandepe.physicsapp

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.iwandepe.physicsapp.databinding.FragmentConversionBinding
import kotlin.time.milliseconds

class ConversionFragment : Fragment(){

    private var unitOfLengthTo: Double = 0.0
    private var unitOfLengthFrom: Double = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentConversionBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_conversion, container, false
        )
        val spinnerFrom: Spinner = binding.fromConversionDropdown
        val spinnerTo: Spinner = binding.toConversionDropdown
        val inputConversionText: EditText = binding.inputConversionText
        val resultConversionText: TextView = binding.resultConversion

        // Create dropdown view from resource
        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.unit_of_length_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->

            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            // Apply the adapter to the spinner
            spinnerTo.adapter = adapter
            spinnerFrom.adapter = adapter
        }

        binding.convertButton.setOnClickListener {
            val input: String = inputConversionText.text.toString()

            // Input validation
            if (input.isEmpty()){
                inputConversionText.error = "Value cannot be empty"
            }
            else {
                val result: Double = input.toDouble() * Math.pow(10.0, unitOfLengthFrom) / Math.pow(10.0, unitOfLengthTo)
                resultConversionText.text = result.toString()
                resultConversionText.visibility = View.VISIBLE
            }
        }

        spinnerFrom.onItemSelectedListener = SpinnerFromClass()
        spinnerTo.onItemSelectedListener = SpinnerToClass()

        return binding.root
    }

    private inner class SpinnerFromClass : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
            // Do nothing
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            unitOfLengthFrom = position.toDouble()
//            Toast.makeText(view!!.context, position.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private inner class SpinnerToClass : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
            // Do nothing
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            unitOfLengthTo = position.toDouble()
        }
    }

}
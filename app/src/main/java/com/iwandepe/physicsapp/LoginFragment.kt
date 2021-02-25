package com.iwandepe.physicsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.iwandepe.physicsapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login, container, false)
        var editTextEmail: EditText = binding.emailInput
        var editTextPassword: EditText = binding.passwordInput
        binding.loginButton.setOnClickListener { v: View ->
            val email:String = editTextEmail.text.toString()
            val password:String = editTextPassword.text.toString()

            // Validate input email and password
            if (email.isEmpty()){
                editTextEmail.error = "Email cannot empty"
            }
            if (password.isEmpty()){
                editTextPassword.error = "Password cannot empty"
            }
            else if (password.length < 6) {
                editTextPassword.error = "Password cannot less than 6 character"
            }

            // Check if the email and password are correct
            if (email.equals("iwan@gmail.com") && password.equals("iwandwiprakoso")) {
                v.findNavController().navigate(R.id.action_loginFragment_to_menuFragment)
            }
            else {
                Toast.makeText(requireActivity(), "Email or password wrong", Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }
}
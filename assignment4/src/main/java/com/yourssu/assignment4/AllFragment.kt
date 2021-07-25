package com.yourssu.assignment4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yourssu.assignment4.databinding.FragmentAllBinding
import kotlinx.android.synthetic.main.fragment_all.*
import kotlinx.android.synthetic.main.fragment_birthday.*
import kotlinx.android.synthetic.main.fragment_name.*
import kotlinx.android.synthetic.main.fragment_school.*

class AllFragment : Fragment() {
    private var _binding: FragmentAllBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.nameTextView.text = App.prefs.getString("nameEditText", "")
        binding.birthdayTextView.text = App.prefs.getString("birthdayEditText", "")
        binding.schoolTextView.text = App.prefs.getString("schoolEditText", "")
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                AllFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}
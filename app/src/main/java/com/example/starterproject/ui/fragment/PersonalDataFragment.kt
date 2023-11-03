package com.example.starterproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.starterproject.R
import com.example.starterproject.databinding.FragmentPersonalDataBinding
import com.example.starterproject.ui.SharedViewModel

class PersonalDataFragment : Fragment() {
    private val sharedViewModel: SharedViewModel by activityViewModels()

    private var _binding: FragmentPersonalDataBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPersonalDataBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getDetail()
        setListener()
    }

    private fun getDetail() {
        sharedViewModel.message.observe(viewLifecycleOwner) {
            binding.apply {
                textName.text = "Personal Data: $it"
            }
        }
    }

    private fun setListener() {
        binding.apply {
            buttonNext.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_personalDataFragment_to_educationDataFragment)
            }
        }
    }
}
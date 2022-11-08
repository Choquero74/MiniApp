package com.example.miniapp.ui.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.miniapp.R
import com.example.miniapp.databinding.FragmentEventBinding

class EventFragment : Fragment() {

    private var _binding: FragmentEventBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val eventViewModel =
            ViewModelProvider(this)[EventViewModel::class.java]

        _binding = FragmentEventBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textEvent
        eventViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button1.setOnClickListener {
            findNavController().navigate(R.id.nav_type)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.roomp3.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.roomp3.R
import com.example.roomp3.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {
    
    private lateinit var binding: FragmentMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentMenuBinding.inflate(inflater,container,false)


        binding.btnTBuscar.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_searchFragment)

        }

        binding.btnTBorrar.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_deleteFragment)
        }

        binding.btnTAgregar.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_addFragment)
        }

        binding.btnTActualizar.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_updateFragment)
        }

        return binding.root
    }




}
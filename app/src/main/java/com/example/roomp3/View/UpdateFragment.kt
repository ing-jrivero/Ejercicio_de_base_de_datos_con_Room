package com.example.roomp3.View

import android.os.Bundle
import android.text.style.DrawableMarginSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.roomp3.MisNotasApp
import com.example.roomp3.Model.RegistroEntity
import com.example.roomp3.R
import com.example.roomp3.databinding.FragmentUpdateBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class UpdateFragment : Fragment() {

    private lateinit var binding: FragmentUpdateBinding
    lateinit var Registro: RegistroEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUpdateBinding.inflate(inflater,container,false)

        binding.btnUpdate.setOnClickListener {
            val nombre = binding.etNombreUpdate.text.toString()
            val email = binding.etEmailUpdate.text.toString()
            val telefono = binding.etTelefonoUpdate.text.toString()
            updateRegistro(RegistroEntity(email,nombre,telefono) )
        }


        return binding.root
    }

    private fun updateRegistro(registro: RegistroEntity) {
        doAsync {
            MisNotasApp.database.registroDao().updateRegistro(registro)
            uiThread {
                clearFocus()
                Toast.makeText(activity,"Datos Actualizados Correctamente",Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun clearFocus() {
        binding.etEmailUpdate.setText("")
        binding.etNombreUpdate.setText("")
        binding.etTelefonoUpdate.setText("")
    }


}
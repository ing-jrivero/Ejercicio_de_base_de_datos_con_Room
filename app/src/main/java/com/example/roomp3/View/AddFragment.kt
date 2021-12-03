package com.example.roomp3.View

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.roomp3.MisNotasApp
import com.example.roomp3.Model.RegistroEntity
import com.example.roomp3.R
import com.example.roomp3.databinding.FragmentAddBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    lateinit var Registros: MutableList<RegistroEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddBinding.inflate(inflater,container,false)

        binding.btnAgregar.setOnClickListener {
            addRegistro(RegistroEntity(email = binding.etEmailAdd.text.toString(),
                                        nombre = binding.etNombreAdd.text.toString(),
                                        telefono = binding.etTelefonoAdd.text.toString()))
        }




        return binding.root
    }

    private fun addRegistro(registro: RegistroEntity) {
        doAsync {
            val id = MisNotasApp.database.registroDao().addRegistro(registro)
         //   val recoveryRegistro = MisNotasApp.database.registroDao().getRegitroById(id)
            uiThread {
              //  Registros.add(recoveryRegistro)
                clearFocus()
                Toast.makeText(activity,"Datos Guardados",Toast.LENGTH_SHORT).show()


            }

        }

    }


    private fun clearFocus() {
        binding.etEmailAdd.setText("")
        binding.etNombreAdd.setText("")
        binding.etTelefonoAdd.setText("")
    }

}
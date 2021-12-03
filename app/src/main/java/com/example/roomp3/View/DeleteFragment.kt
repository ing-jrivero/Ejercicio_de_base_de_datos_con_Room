package com.example.roomp3.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.roomp3.MisNotasApp
import com.example.roomp3.R
import com.example.roomp3.databinding.FragmentDeleteBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class DeleteFragment : Fragment() {

    private lateinit var binding : FragmentDeleteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDeleteBinding.inflate(inflater,container,false)

        binding.btnEliminar.setOnClickListener {
            val email = binding.etEmailDelete.text.toString()
            deleteRegistro(email)

        }
        return binding.root
    }

    private fun deleteRegistro(email: String) {
        doAsync {
            val registro = MisNotasApp.database.registroDao().getRegitroById(email)
            val result = MisNotasApp.database.registroDao().deleteRegistro(registro)
            clearFocus()
            Toast.makeText(activity,"R: $result",Toast.LENGTH_SHORT).show()

            uiThread {

                if(registro.nombre!=""){
                    Toast.makeText(activity,"Registro Eliminado",Toast.LENGTH_SHORT).show()
                    clearFocus()
                }else{
                    Toast.makeText(activity,"Registro No encontrado",Toast.LENGTH_SHORT).show()
                }


            }
        }

    }

    private fun clearFocus() {
        binding.etEmailDelete.setText("")
    }


}
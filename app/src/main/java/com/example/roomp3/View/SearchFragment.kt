package com.example.roomp3.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.roomp3.MisNotasApp
import com.example.roomp3.Model.RegistroEntity
import com.example.roomp3.R
import com.example.roomp3.databinding.FragmentSearchBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class SearchFragment : Fragment() {

    private lateinit var binding : FragmentSearchBinding
    lateinit var Registro: RegistroEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentSearchBinding.inflate(inflater,container,false)

        binding.btnBuscar.setOnClickListener {
            val email = binding.etEmailSearch.text.toString()
            getRegistroById(email)


        }

        return binding.root
    }

    private fun getRegistroById(email: String) {
        val i =0

        doAsync {
            var r = MisNotasApp.database.registroDao().getRegitroById(email)
            Registro = MisNotasApp.database.registroDao().getRegitroById(email)

            uiThread {
                setearDatos(r)
                clearFocus()
            }
            /*uiThread {
                if(Registro.email.isNullOrEmpty()){
                    Toast.makeText(activity,"nombre: "+Registro.nombre,Toast.LENGTH_SHORT).show()
                   setearDatos(r)
                }else{
                    Toast.makeText(activity,"ERROR: No se encontro Registro",Toast.LENGTH_SHORT).show()
                }

            }*/

        }




    }

    private fun clearFocus() {
        binding.etEmailSearch.setText("")
    }


    private fun setearDatos(i: RegistroEntity){
     //   Toast.makeText(activity,"nombre: "+i.nombre,Toast.LENGTH_SHORT).show()
        binding.tvNombre.text = Registro.nombre
        binding.tvEmail.text = Registro.email
        binding.tvTelefono.text = Registro.telefono
        mostrarView()

    }


    private fun mostrarView() {
        binding.tvDatos.visibility = View.VISIBLE
        binding.tvTnombre.visibility = View.VISIBLE
        binding.tvNombre.visibility = View.VISIBLE
        binding.tvTemail.visibility = View.VISIBLE
        binding.tvEmail.visibility = View.VISIBLE
        binding.tvTtelefono.visibility = View.VISIBLE
        binding.tvTelefono.visibility = View.VISIBLE



    }


}
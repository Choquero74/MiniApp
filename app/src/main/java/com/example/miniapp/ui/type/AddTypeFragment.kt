package com.example.miniapp.ui.type

/**
 * Fragmento de Añadir Tipo.
 * Clase que hereda de Fragment y se encarga de mostrar la interfaz de usuario para añadir tipos.
 * Layout: fragment_add_type.xml
 * @author Choquero
 * @version 1, 2022/10
 */

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.miniapp.R
import com.example.miniapp.databinding.FragmentAddTypeBinding
import com.example.miniapp.db.database.MiniAppDB
import com.example.miniapp.db.entity.TypeEntity
import kotlinx.coroutines.launch

class AddTypeFragment : Fragment() {

    private var _binding: FragmentAddTypeBinding? = null

    // Esta propiedad sólo es válida entre onCreateView y onDestroyView.
    private val binding get() = _binding!!

    /**
     * Método que se ejecuta al crear la vista.
     * @param inflater: LayoutInflater
     * @param container: ViewGroup?
     * @param savedInstanceState: Bundle?
     * @return View
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddTypeBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Método que se ejecuta al crear la vista.
     * @param view: View
     * @param savedInstanceState: Bundle?
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bSaveType.setOnClickListener { addType() }
    }

    /**
     * Función para agregar un tipo de gasto.
     * Recoge el texto introducido en el etType (EditText) y lo guarda en la base de datos.
     * Genera un Toast para confirmar que se ha guardado correctamente y navega hacia el RecyclerView de tipos.
     */
    private fun addType() {
        val type = binding.etType.text.toString()
        lifecycleScope.launch {
            val type = TypeEntity(type = type)
            MiniAppDB.getDatabase(requireContext()).typeDao().insertType(type)
        }
        val msg = R.string.msg
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.nav_type)
    }

    /**
     * Método que se ejecuta al destruir la vista.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
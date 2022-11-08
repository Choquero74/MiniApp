package com.example.miniapp.ui.type

/**
 * Adaptador de Tipo.
 * TypeAdapter es una clase de adaptador para configurar todos los elementos en la vista del reciclador (RecyclerView).
 * @author Choquero
 * @version 1, 2022/10
 */

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.miniapp.R
import com.example.miniapp.databinding.FragmentTypeBinding
import com.example.miniapp.db.entity.TypeEntity

class TypeFragment : Fragment(), TypeUpdateIconClickInterface, TypeDeleteIconClickInterface {

    private var _binding: FragmentTypeBinding? = null

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mLayoutManager: RecyclerView.LayoutManager
    private lateinit var mAdapter: RecyclerView.Adapter<*>

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    /**
     * Método sobrescrito para crear la vista.
     * @param inflater inflador de la vista.
     * @param container contenedor de la vista.
     * @param savedInstanceState estado de la instancia.
     * @return vista creada.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTypeBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Método sobrescrito para inicializar la vista.
     * @param savedInstanceState estado de la instancia.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.nav_event)
        }

        binding.fabType.setOnClickListener {
            findNavController().navigate(R.id.nav_add_type)
        }
    }

    /**
     * Método sobrescrito para destruir la vista.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onTypeUpdateIconClick(type: TypeEntity) {
        TODO("Not yet implemented")
    }

    override fun onTypeDeleteIconClick(type: TypeEntity) {
        TODO("Not yet implemented")
    }
}
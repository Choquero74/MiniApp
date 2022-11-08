package com.example.miniapp.ui.type

/**
 * Adaptador de Tipo.
 * TypeAdapter es una clase de adaptador para configurar todos los elementos en la vista del reciclador (RecyclerView).
 * @author Choquero
 * @version 1, 2022/10
 */

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miniapp.databinding.CustomRowTypeBinding
import com.example.miniapp.db.entity.TypeEntity

class TypeAdapter(
    private val typeDeleteIconClickInterface: TypeDeleteIconClickInterface,
    private val typeUpdateIconClickInterface: TypeUpdateIconClickInterface
) : RecyclerView.Adapter<TypeViewHolder>() {

    private val allTypes = ArrayList<TypeEntity>()

    /**
     * Método sobrescrito para crear la vista.
     * @param newList nueva lista de tipos.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        val binding = CustomRowTypeBinding.inflate(inflater, parent, false)
        return TypeViewHolder(binding)
    }

    /**
     * Método sobrescrito para actualizar la lista de tipos.
     * @param newList nueva lista de tipos.
     */
    override fun onBindViewHolder(holder: TypeViewHolder, position: Int) {

        // Establece los datos en el elemento de la vista del RecyclerView.
        holder.binding.tvTypeRowNumber.text = allTypes[position].id.toString()
        holder.binding.tvTypeRowText.text = allTypes[position].type

        // Añadimos un "listener" al icono de borrar.
        holder.binding.ibTypeDelete.setOnClickListener {
            // call typeDeleteIconClickInterface.onTypeDeleteIconClick() and pass position to it.
            typeDeleteIconClickInterface.onTypeDeleteIconClick(allTypes[position])
        }

        // Añadimos un "listener" al icono de actualizar.
        holder.binding.ibTypeUpdate.setOnClickListener {
            // call typeUpdateIconClickInterface.onTypeUpdateIconClick() and pass position to it.
            typeUpdateIconClickInterface.onTypeUpdateIconClick(allTypes[position])
        }
    }

    /**
     * Método sobrescrito que retorna el tamaño de la lista de tipos.
     * @return número de elementos de la lista.
     */
    override fun getItemCount(): Int {
        return allTypes.size
    }

    /**
     * Método para actualizar la lista de tipos.
     * @param newList nueva lista de tipos.
     */
    fun updateList(newList: List<TypeEntity>) {

        // limpia todos los datos previios.
        allTypes.clear()

        // añade todos los elementos a la nueva lista.
        allTypes.addAll(newList)

        // call notifyDataSetChanged() to notify our adapter.
        notifyDataSetChanged()
    }
}

interface TypeDeleteIconClickInterface {
    // creating a method for click
    // action on delete image view.
    fun onTypeDeleteIconClick(type : TypeEntity)
}

interface TypeUpdateIconClickInterface {
    // creating a method for click action
    // on recycler view item for updating it.
    fun onTypeUpdateIconClick(type: TypeEntity)
}

class TypeViewHolder(val binding: CustomRowTypeBinding) : RecyclerView.ViewHolder(binding.root)
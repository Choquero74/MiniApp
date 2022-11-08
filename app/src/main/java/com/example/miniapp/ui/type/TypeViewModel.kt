package com.example.miniapp.ui.type

/**
 * ViewModel para Tipo.
 * ViewModel se usa básicamente para proporcionar los datos a nuestra interfaz de usuario. Actúa como una capa de comunicación entre el repositorio y la interfaz de usuario.
 * @author Choquero
 * @version 1, 2022/10
 */

import android.app.Application
import androidx.lifecycle.*
import com.example.miniapp.db.database.MiniAppDB
import com.example.miniapp.db.entity.TypeEntity
import com.example.miniapp.db.repository.MiniAppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TypeViewModel (
    application: Application
) : AndroidViewModel(application) {

    private val _text = MutableLiveData<String>().apply {
        value = "TYPE"
    }
    val text: LiveData<String> = _text

    private val allTypes: Flow<List<TypeEntity>>
    private val repository: MiniAppRepository

    init {
        val dao = MiniAppDB.getDatabase(application).typeDao()
        repository = MiniAppRepository(dao)
        allTypes = repository.allTypes
    }

    /**
     * Función para insertar un tipo.
     * @param type Tipo a insertar.
     */
    fun insert(typeEntity: TypeEntity) = viewModelScope.launch {
        repository.insert(typeEntity)
    }

    /**
     * Función para actualizar un tipo.
     * @param type Tipo a actualizar.
     */
    fun update(typeEntity: TypeEntity) = viewModelScope.launch {
        repository.update(typeEntity)
    }

    /**
     * Función para borrar un tipo.
     * @param type Tipo a borrar.
     */
    fun delete(typeEntity: TypeEntity) = viewModelScope.launch {
        repository.delete(typeEntity)
    }

    /**
     * Función para borrar todos los tipos.
     * @param type Tipos a devolver.
     */
    fun getAllTypes(): Flow<List<TypeEntity>> {
        return allTypes
    }

    /**
     * Función para borrar todos los tipos.
     * @param type Tipos a borrar.
     */
    fun deleteAll() = viewModelScope.launch {
        repository.deleteAllTypes()
    }
}
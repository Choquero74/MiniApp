package com.example.miniapp.db.dao

import androidx.room.*
import com.example.miniapp.db.entity.TypeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TypeDao {

    // Insertar nuevo tipo.
    @Insert(entity = TypeEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertType(typeEntity: TypeEntity)

    // Actualizar tipo.
    @Update(entity = TypeEntity::class)
    suspend fun updateType(typeEntity: TypeEntity)

    // Eliminar tipo.
    @Delete(entity = TypeEntity::class)
    suspend fun deleteType(typeEntity: TypeEntity)

    // Seleccionar todos los tipos de la tabla.
    @Query("SELECT * FROM type_table")
    fun getAllTypes(): Flow<List<TypeEntity>>

    // Seleccionar un tipo por su ID.
    @Query("SELECT * FROM type_table WHERE id = :id")
    suspend fun getTypeById(id: Int): TypeEntity?

    // Borrar toda la tabla.
    @Query("DELETE FROM type_table")
    suspend fun deleteAllTypes()
}
package com.example.miniapp.db.repository

import androidx.annotation.WorkerThread
import com.example.miniapp.db.dao.TypeDao
import com.example.miniapp.db.entity.TypeEntity
import kotlinx.coroutines.flow.Flow

// Declaramos DAO como propiedad privada en el constructor. Pasamos el DAO
// en lugar de toda la base de datos, porque solo necesitamos acceso al DAO.
class MiniAppRepository(private val typeDao: TypeDao) {

    // Room ejecuta todas las consultas en un hilo separado.
    // El flujo observado notificará al observador cuando los datos hayan cambiado.
    val allTypes: Flow<List<TypeEntity>> = typeDao.getAllTypes()

    // Por defecto, Room ejecuta consultas suspendidas fuera del hilo principal, por lo tanto, no necesitamos
    // implementar cualquier otra cosa para asegurarnos de que no estamos haciendo un trabajo de base de datos de larga duración
    // fuera del hilo principal.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(typeEntity: TypeEntity) {
        typeDao.insertType(typeEntity)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(typeEntity: TypeEntity) {
        typeDao.updateType(typeEntity)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(typeEntity: TypeEntity) {
        typeDao.deleteType(typeEntity)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getTypeById(id: Int): TypeEntity? {
        return typeDao.getTypeById(id)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteAllTypes() {
        typeDao.deleteAllTypes()
    }
}
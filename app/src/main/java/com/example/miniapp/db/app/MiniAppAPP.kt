package com.example.miniapp.db.app

import android.app.Application
import com.example.miniapp.db.database.MiniAppDB
import com.example.miniapp.db.repository.MiniAppRepository

class MiniAppAPP : Application() {

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    private val database by lazy { MiniAppDB.getDatabase(this) }
    val repository by lazy { MiniAppRepository(database.typeDao()) }
}
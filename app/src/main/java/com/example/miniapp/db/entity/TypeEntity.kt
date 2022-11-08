package com.example.miniapp.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "type_table")
data class TypeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id") val id: Int = 0,
    @ColumnInfo(name = "Type") val type: String
)

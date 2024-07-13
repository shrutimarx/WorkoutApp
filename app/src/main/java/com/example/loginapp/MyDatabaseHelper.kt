package com.example.loginapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "my_database.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        // Create your tables here
        val createTableQuery = """
            CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT UNIQUE NOT NULL,
                password TEXT NOT NULL
            )
        """.trimIndent()
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Handle database upgrades here
        if (oldVersion < newVersion) {
            // Drop older tables if needed and recreate them
            db.execSQL("DROP TABLE IF EXISTS users")
            onCreate(db)
        }
    }
}
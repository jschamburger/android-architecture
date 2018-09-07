package com.example.android.architecture.blueprints.todoapp

import android.app.Application
import com.example.android.architecture.blueprints.todoapp.di.appModules
import org.koin.android.ext.android.startKoin

class ToDoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, appModules)
    }
}
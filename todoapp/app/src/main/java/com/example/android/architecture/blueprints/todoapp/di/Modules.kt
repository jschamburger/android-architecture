package com.example.android.architecture.blueprints.todoapp.di

import com.example.android.architecture.blueprints.todoapp.repositoryModule
import com.example.android.architecture.blueprints.todoapp.tasks.TasksFragment
import org.koin.dsl.module.module

val appModule = module {
    factory { TasksFragment() }
}

val appModules = listOf(repositoryModule, appModule)
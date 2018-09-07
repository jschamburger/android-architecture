package com.example.android.architecture.blueprints.todoapp

import com.example.android.architecture.blueprints.todoapp.data.FakeTasksRemoteDataSource
import com.example.android.architecture.blueprints.todoapp.data.source.TasksDataSource
import com.example.android.architecture.blueprints.todoapp.data.source.TasksRepository
import com.example.android.architecture.blueprints.todoapp.data.source.local.TasksLocalDataSource
import com.example.android.architecture.blueprints.todoapp.data.source.local.ToDoDatabase
import com.example.android.architecture.blueprints.todoapp.util.AppExecutors
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val repositoryModule = module {
    single { ToDoDatabase.getInstance(androidContext()) }
    single { (get() as ToDoDatabase).taskDao() }
    single("remoteDataSource") { FakeTasksRemoteDataSource.getInstance() as TasksDataSource }
    single("localDataSource") { TasksLocalDataSource.getInstance(AppExecutors(), get()) as TasksDataSource }
    single { TasksRepository(get("remoteDataSource"), get("localDataSource")) }
}

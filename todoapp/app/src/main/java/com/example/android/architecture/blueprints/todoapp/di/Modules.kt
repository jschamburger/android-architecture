package com.example.android.architecture.blueprints.todoapp.di

import com.example.android.architecture.blueprints.todoapp.addedittask.AddEditTaskFragment
import com.example.android.architecture.blueprints.todoapp.repositoryModule
import com.example.android.architecture.blueprints.todoapp.statistics.StatisticsFragment
import com.example.android.architecture.blueprints.todoapp.taskdetail.TaskDetailFragment
import com.example.android.architecture.blueprints.todoapp.tasks.TasksContract
import com.example.android.architecture.blueprints.todoapp.tasks.TasksFragment
import com.example.android.architecture.blueprints.todoapp.tasks.TasksPresenter
import org.koin.dsl.module.module

val appModule = module {
    factory { TasksFragment() }
    factory { TasksPresenter() as TasksContract.Presenter }

    factory { TaskDetailFragment() }


    factory { AddEditTaskFragment() }


    factory { StatisticsFragment() }
}

val appModules = listOf(repositoryModule, appModule)
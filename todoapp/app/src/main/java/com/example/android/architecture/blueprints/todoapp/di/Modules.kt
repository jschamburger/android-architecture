package com.example.android.architecture.blueprints.todoapp.di

import com.example.android.architecture.blueprints.todoapp.addedittask.AddEditTaskContract
import com.example.android.architecture.blueprints.todoapp.addedittask.AddEditTaskFragment
import com.example.android.architecture.blueprints.todoapp.addedittask.AddEditTaskPresenter
import com.example.android.architecture.blueprints.todoapp.repositoryModule
import com.example.android.architecture.blueprints.todoapp.statistics.StatisticsFragment
import com.example.android.architecture.blueprints.todoapp.taskdetail.TaskDetailContract
import com.example.android.architecture.blueprints.todoapp.taskdetail.TaskDetailFragment
import com.example.android.architecture.blueprints.todoapp.taskdetail.TaskDetailPresenter
import com.example.android.architecture.blueprints.todoapp.tasks.TasksContract
import com.example.android.architecture.blueprints.todoapp.tasks.TasksFragment
import com.example.android.architecture.blueprints.todoapp.tasks.TasksPresenter
import org.koin.dsl.module.module

val appModule = module {
    factory { TasksFragment() }
    factory { TasksPresenter() as TasksContract.Presenter }

    factory { TaskDetailFragment() }
    // TODO: use correct task ID
    factory { TaskDetailPresenter("") as TaskDetailContract.Presenter }

    factory { AddEditTaskFragment() }
    // TODO: use correct task ID and missing flag
    factory { AddEditTaskPresenter("", false) as AddEditTaskContract.Presenter }

    factory { StatisticsFragment() }
}

val appModules = listOf(repositoryModule, appModule)
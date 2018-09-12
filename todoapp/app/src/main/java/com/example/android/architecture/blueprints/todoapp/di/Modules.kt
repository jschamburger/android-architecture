package com.example.android.architecture.blueprints.todoapp.di

import com.example.android.architecture.blueprints.todoapp.addedittask.AddEditTaskContract
import com.example.android.architecture.blueprints.todoapp.addedittask.AddEditTaskFragment
import com.example.android.architecture.blueprints.todoapp.addedittask.AddEditTaskPresenter
import com.example.android.architecture.blueprints.todoapp.repositoryModule
import com.example.android.architecture.blueprints.todoapp.statistics.StatisticsContract
import com.example.android.architecture.blueprints.todoapp.statistics.StatisticsFragment
import com.example.android.architecture.blueprints.todoapp.statistics.StatisticsPresenter
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
    factory { TaskDetailPresenter(getProperty(Properties.EXTRA_TASK_ID)) as TaskDetailContract.Presenter }

    factory { AddEditTaskFragment() }
    // TODO: use correct task ID and missing flag
    factory { AddEditTaskPresenter(getProperty(Properties.ARGUMENT_EDIT_TASK_ID), false) as AddEditTaskContract.Presenter }

    factory { StatisticsFragment() }
    factory { StatisticsPresenter() as StatisticsContract.Presenter }
}

val appModules = listOf(repositoryModule, appModule)

object Properties {
    const val CURRENT_FILTERING_KEY = "CURRENT_FILTERING_KEY"
    const val EXTRA_TASK_ID = "TASK_ID"
    const val ARGUMENT_EDIT_TASK_ID = "EDIT_TASK_ID"
    const val SHOULD_LOAD_DATA_FROM_REPO_KEY = "SHOULD_LOAD_DATA_FROM_REPO_KEY"
}

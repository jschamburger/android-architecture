package com.example.android.architecture.blueprints.todoapp.tasks

import com.example.android.architecture.blueprints.todoapp.data.source.TasksRepository
import com.example.android.architecture.blueprints.todoapp.di.appModules
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.StandAloneContext.stopKoin
import org.koin.standalone.get
import org.koin.standalone.inject
import org.koin.test.KoinTest
import org.koin.test.declareMock
import org.mockito.Mockito.verify

class TasksPresenterKoinTest : KoinTest {

    val presenter: TasksContract.Presenter by inject()

    @Before
    fun setUp() {
        startKoin(appModules)
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun loadAllTasksFromRepositoryAndLoadIntoView() {
        declareMock<TasksRepository>()
        declareMock<TasksContract.View>()
        val mockRepository = get<TasksRepository>()
        val mockView = get<TasksContract.View>()
        presenter.view = mockView

        presenter.loadTasks(true)

        verify(mockView).setLoadingIndicator(true)
        verify(mockRepository).refreshTasks()
    }
}
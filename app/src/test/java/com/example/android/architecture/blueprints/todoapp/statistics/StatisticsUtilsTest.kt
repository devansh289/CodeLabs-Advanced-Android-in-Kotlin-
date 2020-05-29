package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {

        // Create an active task (the false makes this active)
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = false)
        )
        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsZeroHundred() {

        // Create an active task (the false makes this active)
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = true)
        )
        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsFortySixty() {

        // Create an active task (the false makes this active)
        val tasks = listOf<Task>(
                Task("1", "1desc", isCompleted = true),
                Task("2", "2desc", isCompleted = true),
                Task("3", "3desc", isCompleted = true),
                Task("4", "4desc", isCompleted = false),
                Task("5", "5desc", isCompleted = false)
        )
        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.activeTasksPercent, `is`(40f))
        assertThat(result.completedTasksPercent, `is`(60f))
    }
}
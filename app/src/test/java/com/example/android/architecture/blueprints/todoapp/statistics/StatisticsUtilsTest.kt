package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.assertEquals
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompleteTasks_noCompleted_returnsZeroOneHundred() {
        val tasks = listOf(Task("title", "description", false))
        val statsResult = getActiveAndCompletedStats(tasks)
        assertEquals(statsResult.activeTasksPercent, 100f)
        assertEquals(statsResult.completedTasksPercent, 0f)
    }

    @Test
    fun getActiveAndCompleteTasks_allCompleted_returnsOneHundredZero() {
        val tasks = listOf(Task("title", "description", true))
        val statsResult = getActiveAndCompletedStats(tasks)
        assertEquals(statsResult.activeTasksPercent, 0f)
        assertEquals(statsResult.completedTasksPercent, 100f)
    }

    @Test
    fun getActiveAndCompleteTasks_oneActiveOneCompleted_returns5050() {
        val tasks = listOf(
            Task("title1", "description1", true),
            Task("title2", "description2", false)
        )
        val statsResult = getActiveAndCompletedStats(tasks)
        assertEquals(statsResult.activeTasksPercent, 50f)
        assertEquals(statsResult.completedTasksPercent, 50f)
    }

    @Test
    fun getActiveAndCompleteTasks_emptyTasks_returnsZeroes(){
        val tasks = emptyList<Task>()
        val statsResult = getActiveAndCompletedStats(tasks)
        assertEquals(statsResult.activeTasksPercent, 0f)
        assertEquals(statsResult.completedTasksPercent, 0f)
    }

    @Test
    fun getActiveAndCompleteTasks_nullTasks_returnsZeroes(){
        val tasks = null
        val statsResult = getActiveAndCompletedStats(tasks)
        assertEquals(statsResult.activeTasksPercent, 0f)
        assertEquals(statsResult.completedTasksPercent, 0f)
    }
}
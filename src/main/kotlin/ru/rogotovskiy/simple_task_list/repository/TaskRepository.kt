package ru.rogotovskiy.simple_task_list.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.rogotovskiy.simple_task_list.model.Task

@Repository
interface TaskRepository : JpaRepository<Task, Long> {
    fun existsByName(name: String): Boolean
}
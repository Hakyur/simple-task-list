package ru.rogotovskiy.simple_task_list.services

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.rogotovskiy.simple_task_list.dto.TaskDTO
import ru.rogotovskiy.simple_task_list.exceptions.DuplicateTaskException
import ru.rogotovskiy.simple_task_list.exceptions.TaskNotFoundException
import ru.rogotovskiy.simple_task_list.mappers.TaskMapper
import ru.rogotovskiy.simple_task_list.model.Task
import ru.rogotovskiy.simple_task_list.repository.TaskRepository

@Service
class TaskService(private val taskRepository: TaskRepository, private val taskMapper: TaskMapper) {

    fun getAll(): List<Task> = taskRepository.findAll()

    fun getTaskById(id: Long): Task = taskRepository.findByIdOrNull(id)
        ?: throw TaskNotFoundException("Задача с id = $id не найдена!")

    fun getById(id: Long): TaskDTO {
        val task = getTaskById(id)
        return taskMapper.toDTO(task)
    }

    fun createTask(taskDTO: TaskDTO) {
        if (taskRepository.existsByName(taskDTO.name)) {
            throw DuplicateTaskException("Задача ${taskDTO.name} уже существует!")
        }
        taskRepository.save(taskMapper.toEntity(taskDTO))
    }

    fun deleteTask(id: Long) {
        val task = getTaskById(id)
        taskRepository.delete(task)
    }

    fun updateTask(id: Long, taskDTO: TaskDTO) {
        val task = getTaskById(id)
        taskRepository.save(Task(
            id = id,
            name = taskDTO.name
        ))
    }
}
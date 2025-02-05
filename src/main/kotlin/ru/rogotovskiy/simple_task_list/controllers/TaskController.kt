package ru.rogotovskiy.simple_task_list.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.rogotovskiy.simple_task_list.dto.SuccessResponse
import ru.rogotovskiy.simple_task_list.dto.TaskDTO
import ru.rogotovskiy.simple_task_list.services.TaskService

@RestController
@RequestMapping("/task")
class TaskController(private val taskService: TaskService) {

    @GetMapping("/read/all")
    fun readAllTasks(): ResponseEntity<Any> = ResponseEntity.ok(taskService.getAll())

    @GetMapping("/read")
    fun readTask(@RequestParam id: Long): ResponseEntity<Any> = ResponseEntity.ok(taskService.getById(id))

    @PostMapping("/create")
    fun createTask(@RequestBody taskDTO: TaskDTO): ResponseEntity<Any> {
        taskService.createTask(taskDTO)
        return ResponseEntity.ok(SuccessResponse("Задача успешно создана"))
    }

    @DeleteMapping("/delete")
    fun deleteTask(@RequestParam id: Long): ResponseEntity<Any> {
        taskService.deleteTask(id)
        return ResponseEntity.ok(SuccessResponse("Задача успешно удалена"))
    }

    @PutMapping("/update")
    fun updateTask(@RequestParam id: Long, @RequestBody taskDTO: TaskDTO) : ResponseEntity<Any> {
        taskService.updateTask(id, taskDTO)
        return ResponseEntity.ok(SuccessResponse("Задача успешно обновлена"))
    }

}
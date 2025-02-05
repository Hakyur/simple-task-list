package ru.rogotovskiy.simple_task_list.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.rogotovskiy.simple_task_list.dto.ErrorResponse
import ru.rogotovskiy.simple_task_list.exceptions.DuplicateTaskException
import ru.rogotovskiy.simple_task_list.exceptions.TaskNotFoundException
import java.time.LocalDateTime

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException::class)
    fun handleTaskNotFoundException(e: TaskNotFoundException): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.NOT_FOUND).body(toErrorResponse(e))

    @ExceptionHandler(DuplicateTaskException::class)
    fun handleDuplicateTaskException(e: DuplicateTaskException): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.BAD_REQUEST).body(toErrorResponse(e))

    private fun toErrorResponse(e: Exception): ErrorResponse =
        ErrorResponse(message = e.message ?: "Неизвестная ошибка", timestamp = LocalDateTime.now())
}
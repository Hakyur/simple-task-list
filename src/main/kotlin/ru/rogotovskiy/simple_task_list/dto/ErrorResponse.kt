package ru.rogotovskiy.simple_task_list.dto

import java.time.LocalDateTime

data class ErrorResponse(val message: String, val timestamp: LocalDateTime)

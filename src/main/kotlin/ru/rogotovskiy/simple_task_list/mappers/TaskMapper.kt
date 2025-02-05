package ru.rogotovskiy.simple_task_list.mappers

import org.springframework.stereotype.Component
import ru.rogotovskiy.simple_task_list.dto.TaskDTO
import ru.rogotovskiy.simple_task_list.model.Task

@Component
class TaskMapper {

    fun toDTO(task: Task): TaskDTO {
        return TaskDTO(task.name)
    }

    fun toEntity(taskDTO: TaskDTO): Task {
        return Task(null, taskDTO.name)
    }

}
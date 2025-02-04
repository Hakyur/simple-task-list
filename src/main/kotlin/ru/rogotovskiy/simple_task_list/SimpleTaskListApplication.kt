package ru.rogotovskiy.simple_task_list

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleTaskListApplication

fun main(args: Array<String>) {
	runApplication<SimpleTaskListApplication>(*args)
}

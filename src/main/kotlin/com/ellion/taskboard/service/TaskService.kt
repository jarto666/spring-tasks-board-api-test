package com.ellion.taskboard.service

import com.ellion.taskboard.model.Task
import com.ellion.taskboard.model.dto.TaskDto
import com.ellion.taskboard.model.toDto
import com.ellion.taskboard.repository.TaskRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class TaskService(private val repository: TaskRepository) {
    fun findAll(): List<TaskDto> = repository.findAll().toDto()

    fun findById(id: UUID): TaskDto? = repository.findByIdOrNull(id)?.toDto()

    fun delete(id: UUID): Unit {
        if (!repository.existsById(id)) { throw IllegalArgumentException("Entity with id $id not found") }

        repository.deleteById(id)
    }

    fun update(id: UUID, title: String? = null, description: String? = null): TaskDto {
        val task = repository.findById(id)
                .orElseThrow { IllegalArgumentException("Task with id $id not found") }

        task.title = title ?: task.title
        task.description = description ?: task.description

        repository.save(task)

        return task.toDto();
    }

    fun create(title: String, description: String): TaskDto {
        val task = Task(title, description, id = UUID.randomUUID())
        repository.save(task)

        return task.toDto()
    }
}
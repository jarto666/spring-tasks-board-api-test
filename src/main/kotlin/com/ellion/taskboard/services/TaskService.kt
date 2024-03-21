package com.ellion.taskboard.services

import com.ellion.taskboard.models.Task
import com.ellion.taskboard.repositories.TaskRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class TaskService(private val repository: TaskRepository) {
    fun findAll(): List<Task> = repository.findAll().toList()
    fun findById(id: UUID): Task? = repository.findByIdOrNull(id)
    fun delete(id: UUID): Unit {
        if (!repository.existsById(id)) { throw IllegalArgumentException("Entity with id $id not found") }

        repository.deleteById(id)
    }
    fun update(id: UUID, title: String? = null, description: String? = null): Task {
        val task = repository.findById(id)
                .orElseThrow { IllegalArgumentException("Task with id $id not found") }

        task.title = title ?: task.title
        task.description = description ?: task.description

        repository.save(task)

        return task;
    }

    fun create(title: String, description: String): Task {
        val task = Task(title, description, id = UUID.randomUUID())
        repository.save(task)

        return task
    }
}
package com.ellion.taskboard.controllers

import com.ellion.taskboard.services.TaskService
import com.ellion.taskboard.exceptions.NotFoundException
import com.ellion.taskboard.models.Task
import com.ellion.taskboard.models.dto.CreateTaskDto
import com.ellion.taskboard.models.dto.UpdateTaskDto
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/tasks")
class TaskController(private val taskService: TaskService) {

    @GetMapping("")
    fun findAll(): List<Task> = taskService.findAll()

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: UUID): Task =
            taskService.findById(id) ?: throw NotFoundException("Task with id '$id' does not exist")

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID) = taskService.delete(id)

    @PostMapping("")
    fun create(@Valid @RequestBody payload: CreateTaskDto): Task =
            taskService.create(payload.title, payload.description)

    @PatchMapping("/{id}")
    fun update(@PathVariable id: UUID, @Valid @RequestBody payload: UpdateTaskDto): Task =
            taskService.update(id, payload.title, payload.description)
}
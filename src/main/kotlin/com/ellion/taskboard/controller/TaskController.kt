package com.ellion.taskboard.controller

import com.ellion.taskboard.exception.NotFoundException
import com.ellion.taskboard.model.dto.CreateTaskDto
import com.ellion.taskboard.model.dto.TaskDto
import com.ellion.taskboard.model.dto.UpdateTaskDto
import com.ellion.taskboard.service.TaskService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/tasks")
class TaskController(private val taskService: TaskService) {

    @GetMapping("")
    fun findAll(): List<TaskDto> = taskService.findAll()

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: UUID): TaskDto =
            taskService.findById(id) ?: throw NotFoundException("Task with id '$id' does not exist")

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID) = taskService.delete(id)

    @PostMapping("")
    fun create(@Valid @RequestBody payload: CreateTaskDto): TaskDto =
            taskService.create(payload.title, payload.description)

    @PatchMapping("/{id}")
    fun update(@PathVariable id: UUID, @Valid @RequestBody payload: UpdateTaskDto): TaskDto =
            taskService.update(id, payload.title, payload.description)
}
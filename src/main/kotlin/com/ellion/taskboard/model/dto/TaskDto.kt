package com.ellion.taskboard.model.dto

import java.time.LocalDateTime
import java.util.*

class TaskDto(
        var id: UUID,
        var title: String,
        var description: String,
        val created: LocalDateTime,
)
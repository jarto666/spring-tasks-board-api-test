package com.ellion.taskboard.model.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

class CreateTaskDto(
        @NotEmpty(message = "Title is required")
        @Size(min = 1, max = 250, message = "The length of title must be between 1 and 50")
        val title: String,

        @NotEmpty(message = "Description is required")
        @Size(min = 1, max = 250, message = "The length of description must be between 1 and 250")
        val description: String
)
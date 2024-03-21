package com.ellion.taskboard.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.Size
import java.time.LocalDateTime
import java.util.*

@Table(name = "tasks")
@Entity
class Task(
        @Column(nullable = false)
        @Size(min = 1, max = 50, message = "The length of title must be between 1 and 50")
        var title: String,

        @Column(nullable = false)
        @Size(min = 1, max = 250, message = "The length of title must be between 1 and 250")
        var description: String,

        @Column(nullable = false)
        val created: LocalDateTime = LocalDateTime.now(),


//        @Version
//        val version: Long = 0,

        @Id
        var id: UUID? = null,
)
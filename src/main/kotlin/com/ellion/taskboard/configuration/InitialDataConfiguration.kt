package com.ellion.taskboard.configuration

import com.ellion.taskboard.repositories.TaskRepository
import com.ellion.taskboard.models.Task
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class InitialDataConfiguration {

    @Bean
    fun databaseInitializer(taskRepository: TaskRepository) = ApplicationRunner {

        val tasks = listOf(
                Task("Template Task 1", "Task 1 description", id = UUID.fromString("9d0077f5-f392-4267-bb01-de172dd0403b")),
                Task("Template Task 2", "Task 2 description", id = UUID.fromString("f2072d8a-0121-4a16-ade2-979a445ff3ba")),
                Task("Template Task 3", "Task 3 description", id = UUID.fromString("791ca9ca-71a6-4f9d-9ba0-25d3e014c0ca"))
        )
        taskRepository.saveAll(tasks)
    }
}
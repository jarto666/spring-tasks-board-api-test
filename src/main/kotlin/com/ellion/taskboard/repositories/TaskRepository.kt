package com.ellion.taskboard.repositories

import com.ellion.taskboard.models.Task
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TaskRepository : CrudRepository<Task, UUID>
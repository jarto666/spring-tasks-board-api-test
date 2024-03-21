package com.ellion.taskboard.repository

import com.ellion.taskboard.model.Task
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TaskRepository : CrudRepository<Task, UUID>
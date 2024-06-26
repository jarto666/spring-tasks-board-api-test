package com.ellion.taskboard.controller

import com.ellion.taskboard.service.TaskService
import com.ellion.taskboard.model.dto.UserDto
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/user")
class UserController(private val taskService: TaskService) {

    @GetMapping("")
    fun userInfo(): UserDto {
        val authentication = SecurityContextHolder.getContext().authentication
        val jwt = authentication.principal as Jwt
        println(jwt.claims)

        return UserDto(jwt.getClaimAsString("user_id"), jwt.getClaimAsString("email"))
    }
}
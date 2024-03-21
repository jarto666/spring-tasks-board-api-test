package com.ellion.taskboard.configuration

import com.ellion.taskboard.exceptions.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionControllerAdvice {
    @ExceptionHandler
    fun handleIllegalStateException(ex: IllegalArgumentException): ResponseEntity<ErrorMessageModel> {

        val errorMessage = ErrorMessageModel(
                HttpStatus.BAD_REQUEST.value(),
                ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler
    fun handleValidationException(ex: MethodArgumentNotValidException): ResponseEntity<ErrorMessageModel> {

        val errorMessage = ErrorMessageModel(
                HttpStatus.BAD_REQUEST.value(),
                ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler
    fun handleValidationException(ex: HttpMessageNotReadableException): ResponseEntity<ErrorMessageModel> {

        val errorMessage = ErrorMessageModel(
                HttpStatus.BAD_REQUEST.value(),
                ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler
    fun handleValidationException(ex: NotFoundException): ResponseEntity<ErrorMessageModel> {

        val errorMessage = ErrorMessageModel(
                HttpStatus.NOT_FOUND.value(),
                ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
    }
}

class ErrorMessageModel(
        var status: Int? = null,
        var message: String? = null
)
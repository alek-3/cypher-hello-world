package com.example.cypherhelloworld

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.NoHandlerFoundException

@RestControllerAdvice
class ApiExceptionHandlerAdvice {

    @ExceptionHandler(NoHandlerFoundException::class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    fun handleNoHandlerFoundException() : ApiErrorResponse {
        return ApiErrorResponse("no handler found")
    }
}

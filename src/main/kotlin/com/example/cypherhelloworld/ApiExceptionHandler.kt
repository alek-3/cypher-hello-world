package com.example.cypherhelloworld

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.NoHandlerFoundException
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.Exception

@RestControllerAdvice
class ApiExceptionHandler : ResponseEntityExceptionHandler() {

    @Override
    override fun handleExceptionInternal(
        ex: Exception,
        body: Any?,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        if (ex is NoHandlerFoundException) {
            val apiError = ApiErrorResponse("no handler found")
            return super.handleExceptionInternal(ex, apiError, headers, status, request)
        }
        return super.handleExceptionInternal(ex, body, headers, status, request)
    }
}
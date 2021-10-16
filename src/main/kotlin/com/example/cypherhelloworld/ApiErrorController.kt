package com.example.cypherhelloworld

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class ApiErrorController : ErrorController {

    @GetMapping("/error")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun showError() : ApiErrorResponse = ApiErrorResponse("something wrong ;-(")
}

package com.example.cypherhelloworld

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @GetMapping("/hello")
    fun hello(): String = "Hello World"

    @GetMapping("/hello/name")
    fun name(@RequestParam name: String): HelloNameResponse = HelloNameResponse("Hello, $name")
}

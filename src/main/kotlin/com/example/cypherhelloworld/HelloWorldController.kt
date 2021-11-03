package com.example.cypherhelloworld

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.Size

@Validated
@RestController
@RequestMapping("/hello")
class HelloWorldController {

    @GetMapping
    fun hello(): String = "Hello World"

    @GetMapping("/name")
    fun name(@RequestParam @Size(min = 3, max = 10) name: String): HelloNameResponse = HelloNameResponse("Hello, $name")

    // 例外テスト用
    @GetMapping("/throw-exception")
    fun throwException() {
        throw ApiException("テスト用のエラーです")
    }
}

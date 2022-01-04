package com.example.cypherhelloworld

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.Size

@EnableConfigurationProperties(ApiMessageProperties::class)
@Validated
@RestController
@RequestMapping("/hello")
class HelloWorldController(
    val apiMessageProperties: ApiMessageProperties
) {

    @GetMapping
    fun hello(): String = "Hello World"

    @GetMapping("/name")
    fun name(@RequestParam @Size(min = 3, max = 10) name: String): HelloNameResponse {
        val call = apiMessageProperties.call
        return HelloNameResponse("Hello, $call, $name")
    }

    // 例外テスト用
    @GetMapping("/throw-exception")
    fun throwException() {
        throw ApiException("テスト用のエラーです")
    }
}

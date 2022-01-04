package com.example.cypherhelloworld

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "message")
data class ApiMessageProperties(
    val call: String
)

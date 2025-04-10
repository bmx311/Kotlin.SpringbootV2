package com.hooba.thisgottawork

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController(){

    @GetMapping("/home")
    fun helloWorld() =  "Welcome to online ordering!"
}
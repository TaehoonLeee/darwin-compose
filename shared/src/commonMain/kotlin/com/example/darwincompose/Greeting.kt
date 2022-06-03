package com.example.darwincompose

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
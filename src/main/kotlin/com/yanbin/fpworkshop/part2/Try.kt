package com.yanbin.fpworkshop.part2

abstract class Try<T>{
    companion object {

    }
}

class Success<T>(val value: T): Try<T>()

class Fail<T>(val error: Throwable): Try<T>()

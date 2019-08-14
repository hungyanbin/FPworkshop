package com.yanbin.fpworkshop.part3

sealed class Option<T> {
    companion object {
        fun <T> create(value: T?): Option<out T> {
            return if (value == null) {
                None
            } else {
                Some(value)
            }
        }
    }
}

class Some<T>(val value: T): Option<T>() {
    override fun toString(): String {
        return "Some[$value]"
    }
}

object None: Option<Nothing>() {
    override fun toString(): String {
        return "None"
    }
}

fun <T, R> Option<T>.map(f: (T) -> R): Option<out R> {
    return when (this) {
        is Some<T> -> Some(f(this.value))
        is None -> None
    }
}

fun <T, R> Option<T>.flatMap(f: (T) -> Option<out R>): Option<out R> {
    return when (this) {
        is Some<T> -> f(value)
        is None -> None
    }
}
package com.yanbin.fpworkshop.part4

import arrow.core.ListK
import arrow.core.extensions.fx
import arrow.core.k
import arrow.syntax.function.memoize

fun main(args: Array<String>) {

    var fib: (Int) -> Int = {it}

    fib = { number: Int ->
        if (number < 2) 1 else fib(number - 1) + fib(number - 2)
    }.memoize()

    val fibList: (Int) -> List<Int> = { count -> List(count) { index -> fib(index)} }



    val foo = listOf(1, 2, 3, 4, 5)
    val oldWay = foo
        .map { it + 2 }
        .flatMap { fibList(it) }



    val newWay = ListK.fx {
        val (a) = listOf(1, 2, 3, 4, 5).k()
        val incA = a + 2
        val (b) = fibList(incA).k()
        b
    }

    println(oldWay)
    println(newWay.toList())
}
package com.yanbin.fpworkshop.part4

import com.yanbin.fpworkshop.part3.*

fun main(args: Array<String>) {
}

fun smaple1() {
    val three = Some(3)
    val plusTwo: (Int) -> Int = TODO()

    println(three.map(plusTwo))
}

fun sample2() {
    val twenty = Some(20)

    //should be none if the number can not divided by two
    val half: (Int) -> Option<out Int> = TODO()

    val result = twenty.flatMap(half)

    println(result)
}

//Given a number 4, should print Some[16], Some[2]
//Given a number 5, should print Some[25], None
//Hint: use Math.sqrt()
fun exercise(number: Int?) {
    val input = Option.create(number)

    val square = TODO()
    val sqrt = TODO()

    val squareResult = TODO()
    val sqrtResult = TODO()

    println("${squareResult.toString()}, ${sqrtResult.toString()}")
}

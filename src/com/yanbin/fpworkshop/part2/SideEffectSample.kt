package com.yanbin.fpworkshop.part2

fun printFunction(value: Int, op: (Int) -> Int) {
    println(value)
    println(op(value))
}
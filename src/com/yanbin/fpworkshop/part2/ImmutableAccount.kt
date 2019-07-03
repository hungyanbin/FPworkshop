package com.yanbin.fpworkshop.part2

import java.lang.IllegalArgumentException

class ImmutableAccount(val no: String, val name: String, val balance: Balance = Balance()) {

    fun debit(amount: Int): ImmutableAccount {
        if(balance.amount < amount) {
            throw IllegalArgumentException("Insufficient balance in account")
        }

        return ImmutableAccount(
            no,
            name,
            Balance(balance.amount - amount)
        )
    }

    fun credit(amount: Int): ImmutableAccount {
        return ImmutableAccount(
            no,
            name,
            Balance(balance.amount + amount)
        )
    }
}

fun main(args: Array<String>) {
    val a = ImmutableAccount("a1", "John", Balance(0))

    val b = a.credit(100)
    println("a = ${a.balance}")
    println("b = ${b.balance}")

    val c = b.debit(20)
    println("b = ${b.balance}")
    println("c = ${c.balance}")
}

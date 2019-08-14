package com.yanbin.fpworkshop.part2

import java.lang.IllegalArgumentException

data class Balance(val amount: Int = 0)

class Account(val no: String, val name: String) {
    var balance: Balance = Balance()

    fun debit(amount: Int) {
        if( balance.amount < amount) {
            throw IllegalArgumentException("Insufficient balance in account")
        }
        balance = Balance(balance.amount - amount)
    }

    fun credit(amount: Int) {
        balance = Balance(balance.amount + amount)
    }
}


fun main(args: Array<String>) {
    val a = Account("a1", "John")
    a.balance = Balance(0)

    a.credit(100)
    println(a.balance)

    a.debit(20)
    print(a.balance)
}

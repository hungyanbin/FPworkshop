package com.yanbin.fpworkshop.part2

import java.lang.IllegalArgumentException

class ADTAccount(val no: String, val name: String, val balance: Balance)

class AccountService {

    fun debit(account: ADTAccount, amount: Int): ADTAccount{
        if(account.balance.amount < amount) {
            throw IllegalArgumentException("Insufficient balance in account")
        }

        return ADTAccount(
            account.no,
            account.name,
            Balance(account.balance.amount - amount)
        )
    }

    fun credit(account: ADTAccount, amount: Int): ADTAccount {
        return ADTAccount(
            account.no,
            account.name,
            Balance(account.balance.amount + amount)
        )
    }
}

fun main(args: Array<String>) {
    val a = ADTAccount("a1", "John", Balance(0))
    val accountService = AccountService()

    val b = accountService.credit(a, 100)
    println("a = ${a.balance}")
    println("b = ${b.balance}")

    val c = accountService.debit(b, 20)
    println("b = ${b.balance}")
    println("c = ${c.balance}")
}

package com.yanbin.fpworkshop.part4

import arrow.core.Try

class AccountApplication {

    fun transfer(from: Account, to: Account, amount: Int) : Try<Pair<Account, Account>> {
        val debitResult = AccountService.debit(from, amount)
        val creditResult = AccountService.credit(to, amount)

        return TODO()
    }

    fun transferAp(from: Account, to: Account, amount: Int) : Try<Pair<Account, Account>> {
        TODO()
    }

    fun transferFx(from: Account, to: Account, amount: Int) : Try<Pair<Account, Account>> {
        TODO()
    }

}

fun main(args: Array<String>) {
    val application = AccountApplication()
    val account1 = Account("1", "Eric", Balance(400))
    val account2 = Account("2", "John", Balance(100))

    val transferResult = application.transfer(account1, account2, 100)
    println(transferResult)
}
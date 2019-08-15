//package com.yanbin.fpworkshop.part4
//
//import arrow.core.Try
//import arrow.core.extensions.`try`.applicative.applicative
//import arrow.core.extensions.`try`.applicative.map
//import arrow.core.extensions.fx
//
//class AccountApplicationAnswer {
//
//    fun transfer(from: Account, to: Account, amount: Int) : Try<Pair<Account, Account>> {
//        val debitResult = AccountService.debit(from, amount)
//        val creditResult = AccountService.credit(to, amount)
//
//        return debitResult.flatMap { accountFrom ->
//            creditResult.map { accountTo -> Pair(accountFrom, accountTo) }
//        }
//    }
//
//    fun transferAp(from: Account, to: Account, amount: Int) : Try<Pair<Account, Account>> {
//        val debitFun: (Account, Int) -> Try<Account> = AccountService.Companion::debit
//        val creditFun: (Account, Int) -> Try<Account> = AccountService.Companion::credit
//
//        return Try.applicative()
//            .tupled(debitFun(from, amount), creditFun(to, amount))
//            .map { Pair(it.a, it.b) }
//    }
//
//    fun transferFx(from: Account, to: Account, amount: Int) : Try<Pair<Account, Account>> {
//        return Try.fx {
//            val (debitResult) = AccountService.debit(from, amount)
//            val (creditResult) = AccountService.credit(to, amount)
//
//            Pair(debitResult, creditResult)
//        }
//    }
//
//}
//
//fun main(args: Array<String>) {
//    val application = AccountApplicationAnswer()
//    val account1 = Account("1", "Eric", Balance(400))
//    val account2 = Account("2", "John", Balance(100))
//
//    val transferResult = application.transferAp(account1, account2, 100)
//    println(transferResult)
//}
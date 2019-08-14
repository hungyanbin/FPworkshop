//package com.yanbin.fpworkshop.part2
//
//import java.lang.IllegalArgumentException
//
//data class ADTAccount(val no: String, val name: String, val balance: Balance)
//
//class AccountService {
//
//    fun debit(account: ADTAccount, amount: Int): Try<ADTAccount> {
//        if (account.balance.amount < amount) {
//            return Fail(IllegalArgumentException("Insufficient balance in account"))
//        }
//
//        return Success(account.copy(balance = Balance(account.balance.amount - amount)))
//    }
//
//    fun credit(account: ADTAccount, amount: Int): Try<ADTAccount> {
//        return Success(account.copy(balance = Balance(account.balance.amount + amount)))
//    }
//
//    fun batchDebit(accounts: List<ADTAccount>, amount: Int): Try<List<ADTAccount>> {
//        val debitAccounts = accounts.map { account -> debit(account, amount) }
//        return if (debitAccounts.any { a -> a is Fail }) {
//            Fail(IllegalArgumentException("Insufficient balance in account"))
//        } else {
//            Success(
//                debitAccounts.map { (it as Success).value }
//            )
//        }
//    }
//
//    fun batchCredit(accounts: List<ADTAccount>, amount: Int): Try<List<ADTAccount>> {
//        return Success(
//            accounts.map { credit(it, amount) }
//                .map { (it as Success).value }
//        )
//    }
//
////    fun batchDebit(accounts: List<ADTAccount>, amount: Int): Try<List<ADTAccount>> {
////        return Try.createList(accounts) { account ->
////            debit(account, amount)
////        }
////    }
////
////    fun batchCredit(accounts: List<ADTAccount>, amount: Int): Try<List<ADTAccount>> {
////        return Try.createList(accounts) { account ->
////            credit(account, amount)
////        }
////    }
//}
//
//fun <T> Try.Companion.createList(list: List<T>, mapper: (T) -> Try<T>): Try<List<T>> {
//    val tryList = list.map(mapper)
//    return if(tryList.any { item -> item is Fail }) {
//        tryList.filterIsInstance<Fail<T>>()
//            .first()
//            .let { Fail<List<T>>(it.error) }
//    } else {
//        Success(tryList.map { (it as Success).value })
//    }
//}
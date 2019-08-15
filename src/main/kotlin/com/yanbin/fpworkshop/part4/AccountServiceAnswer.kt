package com.yanbin.fpworkshop.part4

//class AccountService {
//
//    companion object {
//        //if no or name empty : Account no or name cannot be blank
//        //if open date before now : Cannot open account in the past
//        fun open(no: String, name: String, openDate: LocalDate): Try<Account> {
//            return Try {
//                if (no.isEmpty() || name.isEmpty()) {
//                    throw IllegalArgumentException("Account no or name cannot be blank")
//                } else if (openDate.isBefore(LocalDate.now())) {
//                    throw IllegalArgumentException("Cannot open account in the past")
//                } else {
//                    Account(no, name, Balance(0))
//                }
//            }
//        }
//
//        fun debit(account: Account, amount: Int): Try<Account> {
//            return Try {
//                if (account.balance.amount < amount) {
//                    throw IllegalArgumentException("Insufficient balance in account")
//                } else {
//                    account.copy(balance = Balance(account.balance.amount - amount))
//                }
//
//            }
//        }
//
//        fun credit(account: Account, amount: Int): Try<Account> {
//            return Try {
//                account.copy(balance = Balance(account.balance.amount + amount))
//            }
//        }
//    }
//
//}
//
//fun main(args: Array<String>) {
//    //open a account and save $1000
//    val result = AccountService.open("1", "YY", LocalDate.now())
//        .flatMap { AccountService.debit(it, 1000) }
//
//    println(result)
//}
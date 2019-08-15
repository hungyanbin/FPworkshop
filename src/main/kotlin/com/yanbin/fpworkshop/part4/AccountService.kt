package com.yanbin.fpworkshop.part4

import arrow.core.Try
import java.time.LocalDate

class AccountService {

    companion object {
        //if no or name empty : Account no or name cannot be blank
        //if open date before now : Cannot open account in the past
        fun open(no: String, name: String, openDate: LocalDate): Try<Account> {
            TODO()
        }

        fun debit(account: Account, amount: Int): Try<Account> {
            return Try {
                if (account.balance.amount < amount) {
                    throw IllegalArgumentException("Insufficient balance in account")
                } else {
                    account.copy(balance = Balance(account.balance.amount - amount))
                }

            }
        }

        fun credit(account: Account, amount: Int): Try<Account> {
            return Try {
                account.copy(balance = Balance(account.balance.amount + amount))
            }
        }
    }

}

fun main(args: Array<String>) {
    //open a account and save $1000

    //open a account and withdraw $300

    //open a account -> save $1000 -> withdraw $300
}
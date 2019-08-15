package com.yanbin.fpworkshop.part4

import arrow.core.Try
import java.time.LocalDate

interface Validation {
    fun validateAccountNo(no: String): Try<String>
    fun validateAccountName(name: String): Try<String>
    fun validateOpenDate(date: LocalDate): Try<LocalDate>
}

fun createAccount(validation: Validation, no: String, name: String, date: LocalDate): Try<Account> {
    return validation.validateAccountNo(no).flatMap { vNo ->
        validation.validateAccountName(name).flatMap { vName ->
            validation.validateOpenDate(date).flatMap { vDate ->
                AccountService.open(vNo, vName, vDate)
            }
        }
    }
}
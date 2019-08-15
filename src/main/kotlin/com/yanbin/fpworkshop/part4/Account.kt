package com.yanbin.fpworkshop.part4

data class Balance(val amount: Int = 0)

data class Account(val no: String, val name: String, val balance: Balance)



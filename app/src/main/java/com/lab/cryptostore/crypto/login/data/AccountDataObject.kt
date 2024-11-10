package com.lab.cryptostore.crypto.login.data

import kotlinx.serialization.Serializable

@Serializable
data class AccountDataObject(
    val uid: String = "",
    val email: String = "",
)

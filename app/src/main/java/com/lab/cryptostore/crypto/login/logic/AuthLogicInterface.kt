package com.lab.cryptostore.crypto.login.logic

import com.lab.cryptostore.crypto.login.data.AccountDataObject

interface AuthLogicInterface {
    fun signUp(
        email: String,
        password: String,
        onSignUpSuccess: (AccountDataObject) -> Unit,
        onSignUpFailure: (String) -> Unit
    )
    fun signIn(
        email: String,
        password: String,
        onSignInSuccess: (AccountDataObject) -> Unit,
        onSignInFailure: (String) -> Unit)
    fun deleteAccount(
        email: String,
        password: String)
    fun signOut()
}